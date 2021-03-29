package fpt.aptech.lab06_nsc.entities;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-01-18T11:33:59", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> accountCode;
    public static volatile SingularAttribute<Account, Long> balance;
    public static volatile SingularAttribute<Account, String> accountName;
    public static volatile SingularAttribute<Account, String> pinCode;

}