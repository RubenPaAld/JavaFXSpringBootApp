package com.codetreatise.specs;

import com.codetreatise.bean.*;
import com.codetreatise.parameters.*;
import com.codetreatise.utils.Constantes;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;

public class PedidoSpecs {
    public static Specification<Pedido> getPedidoBySpecs(PedidoParameters p, EntregaParameters e) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (p != null) {

                final List<Campana> campanas = p.getCampanas();

                if (campanas != null && !campanas.isEmpty())
                    predicates.add(getPredicateOR(Pedido_.campana,campanas,criteriaBuilder,root));

                final List<Cadena> cadenas = p.getCadenas();

                if (cadenas != null && !cadenas.isEmpty())
                    predicates.add(getPredicateOR(Pedido_.cadena,cadenas,criteriaBuilder,root));

                final List<Proveedor> proveedores = p.getProveedores();

                if (proveedores != null && !proveedores.isEmpty())
                    predicates.add(getPredicateOR(Pedido_.proveedor,proveedores,criteriaBuilder,root));

                final List<MateriaPrima> materiasPrimas = p.getMateriasPrimas();

                if (materiasPrimas != null && !materiasPrimas.isEmpty())
                    predicates.add(getPredicateOR(Pedido_.materiaPrima,materiasPrimas,criteriaBuilder,root));

                /*final StringComparableParameter metrosPedidoScp = p.getMetrosPedido();

                if (metrosPedidoScp != null)
                    predicates.add(getPredicate(Pedido_.metros, metrosPedidoScp.getTxt(), criteriaBuilder, root, metrosPedidoScp.getOperator()));*/

                final LocalDateIntervalParameter fechaPedidoScp = p.getFechaPedido();

                final LocalDate fPedidoDesde = fechaPedidoScp.getDesde();
                final LocalDate fPedidoHasta = fechaPedidoScp.getHasta();

                if (fPedidoDesde != null && fPedidoHasta != null)
                    predicates.add(getPredicateInterval(Pedido_.fechaPedido,fPedidoDesde,fPedidoHasta,root,criteriaBuilder));

                /*final Boolean completado = p.getCompletado();

                if (completado != null)
                    predicates.add(getPredicate(Pedido_.completado,completado,criteriaBuilder,root));*/
            }

            if (e != null) {

                Join<Pedido,EntregaPedido> epJoin = root.join(Pedido_.entregaPedidos, JoinType.LEFT);

                final List<Destino> destinos = e.getDestinos();

                if (destinos != null && !destinos.isEmpty())
                    predicates.add(getPredicateOR(EntregaPedido_.destino,destinos,criteriaBuilder,epJoin));

                final List<TipoTransporte> tipoTransportes = e.getTipoTransportes();

                if (tipoTransportes != null && !tipoTransportes.isEmpty())
                    predicates.add(getPredicateOR(EntregaPedido_.tipoTransporte,tipoTransportes,criteriaBuilder,epJoin));

                final List<TipoEstadoEntrega> tipoEstadoEntregas = e.getTipoEstadoEntregas();

                if (tipoEstadoEntregas != null && !tipoEstadoEntregas.isEmpty())
                    predicates.add(getPredicateOR(EntregaPedido_.tipoEstadoEntrega,tipoEstadoEntregas,criteriaBuilder,epJoin));

                /*final StringComparableParameter metrosEntregaScp = e.getMetrosEntrega();

                if (metrosEntregaScp != null)
                    predicates.add(getPredicate(EntregaPedido_.metros, metrosEntregaScp.getTxt(), criteriaBuilder, root, metrosEntregaScp.getOperator()));*/

                final LocalDateIntervalParameter fechaSalidaScp = e.getFechaSalida();

                final LocalDate fSalidaDesde = fechaSalidaScp.getDesde();
                final LocalDate fSalidaHasta = fechaSalidaScp.getHasta();

                if (fSalidaDesde != null && fSalidaHasta != null)
                    predicates.add(getPredicateInterval(EntregaPedido_.fechaSalida,fSalidaDesde,fSalidaHasta,root,criteriaBuilder));

                final LocalDateIntervalParameter fechaEstimadaScp = e.getFechaEstimada();

                final LocalDate fEstimadaDesde = fechaEstimadaScp.getDesde();
                final LocalDate fEstimadaHasta = fechaEstimadaScp.getHasta();

                if (fEstimadaDesde != null && fEstimadaHasta != null)
                    predicates.add(getPredicateInterval(EntregaPedido_.fechaSalida,fEstimadaDesde,fEstimadaHasta,root,criteriaBuilder));

                final LocalDateIntervalParameter fechaLlegadaScp = e.getFechaLlegada();

                final LocalDate fLlegadaDesde = fechaLlegadaScp.getDesde();
                final LocalDate fLlegadaHasta = fechaLlegadaScp.getHasta();

                if (fLlegadaDesde != null && fLlegadaHasta != null)
                    predicates.add(getPredicateInterval(EntregaPedido_.fechaSalida,fLlegadaDesde,fLlegadaHasta,root,criteriaBuilder));
            }

            Predicate[] predicatesA = predicates.toArray(new Predicate[0]);

            return query.where(
                        criteriaBuilder.and(predicatesA)
                    ).distinct(true)
                    .getRestriction();
        };
    }

    private static Predicate getPredicateOR(SingularAttribute s, List campos, CriteriaBuilder cb, From from) {

        List<Predicate> predicates = new ArrayList<>();

        for (Object o : campos)
            predicates.add(cb.equal(from.get(s), o));

        return cb.or(predicates.toArray(new Predicate[0]));
    }

    private static Predicate getPredicate(SingularAttribute s, Comparable o, CriteriaBuilder cb, From from, Constantes.OPERATORS operator) {

        System.out.println("OP: " + operator);
        System.out.println("OBJECT: " + o);

        if (o != null && !o.equals("") && operator != null && operator != Constantes.OPERATORS.NOTHING) {
            switch (operator) {
                case LES:
                    return cb.lessThan(from.get(s), o);
                case LES_OR_EQUALS:
                    return cb.lessThanOrEqualTo(from.get(s), o);
                case EQUALS:
                    return cb.equal(from.get(s), o);
                case GREATER_OR_EQUALS:
                    return cb.greaterThanOrEqualTo(from.get(s), o);
                case GREATER:
                    return cb.greaterThan(from.get(s), o);
            }
        }
        return cb.and();
    }

    private static Predicate getPredicateInterval(SingularAttribute s, LocalDate desde, LocalDate hasta, From from, CriteriaBuilder cb) {
        return cb.between(from.get(s),desde,hasta);
    }

    private static Predicate getPredicate(SingularAttribute<Pedido,Boolean> s, Boolean completado, CriteriaBuilder cb, From from) {
        return cb.equal(from.get(s), completado);
    }

}
