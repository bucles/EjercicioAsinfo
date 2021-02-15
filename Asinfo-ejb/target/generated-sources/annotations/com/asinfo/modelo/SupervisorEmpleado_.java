package com.asinfo.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SupervisorEmpleado.class)
public abstract class SupervisorEmpleado_ {

	public static volatile SingularAttribute<SupervisorEmpleado, Empleado> empId;
	public static volatile SingularAttribute<SupervisorEmpleado, Integer> semId;
	public static volatile SingularAttribute<SupervisorEmpleado, Supervisor> supId;
	public static volatile SingularAttribute<SupervisorEmpleado, Date> semFHR;

}

