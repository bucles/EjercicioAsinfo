package com.asinfo.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Departamento.class)
public abstract class Departamento_ {

	public static volatile SingularAttribute<Departamento, Date> depFHR;
	public static volatile ListAttribute<Departamento, Empleado> empleadoList;
	public static volatile SingularAttribute<Departamento, Integer> depId;
	public static volatile SingularAttribute<Departamento, String> depNombre;
	public static volatile SingularAttribute<Departamento, String> depDetalle;

}

