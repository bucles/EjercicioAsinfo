package com.asinfo.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Empleado.class)
public abstract class Empleado_ {

	public static volatile SingularAttribute<Empleado, Long> empSueldo;
	public static volatile SingularAttribute<Empleado, Integer> empId;
	public static volatile SingularAttribute<Empleado, String> empNombre;
	public static volatile SingularAttribute<Empleado, String> empApellido;
	public static volatile SingularAttribute<Empleado, Date> empFHR;
	public static volatile SingularAttribute<Empleado, Departamento> depId;
	public static volatile ListAttribute<Empleado, SupervisorEmpleado> supervisorempleadoList;
	public static volatile SingularAttribute<Empleado, Date> empfechaNac;

}

