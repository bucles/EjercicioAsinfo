package com.asinfo.modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Supervisor.class)
public abstract class Supervisor_ {

	public static volatile SingularAttribute<Supervisor, Date> supFHR;
	public static volatile SingularAttribute<Supervisor, BigDecimal> supSueldo;
	public static volatile SingularAttribute<Supervisor, Integer> supId;
	public static volatile SingularAttribute<Supervisor, Date> supFechaNac;
	public static volatile ListAttribute<Supervisor, SupervisorEmpleado> supervisorempleadoList;
	public static volatile SingularAttribute<Supervisor, String> supNombre;
	public static volatile SingularAttribute<Supervisor, String> supApellido;

}

