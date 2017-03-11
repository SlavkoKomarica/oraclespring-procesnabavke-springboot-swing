package slavko.baze2.procesnabavke.domain;

import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.*;

/**
 * @author Slavko Komarica
 */
public class Jmbg implements UserType, Serializable {

    private String jmbg;


    private static final int SQL_TYPE = Types.STRUCT;
    private static final String OBJECT_TYPE = "JMBG_TYPE";

    public Jmbg() {
    }

    public Jmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Jmbg(Jmbg jmbg) {
        this.jmbg = jmbg.getJmbg();
    }

    /**
     * Returns the object from the 2 level cache
     */
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return cached;
    }

    /**
     * Used to create Snapshots of the object
     */
    public Object deepCopy(Object value) throws HibernateException {
        if (value == null) {
            return null;
        }
        final Jmbg recievedParam = (Jmbg) value;
        final Jmbg addressData = new Jmbg(recievedParam);

        return addressData;
    }

    /**
     * method called when Hibernate puts the data in a second level cache. The
     * data is stored in a serializable form
     */
    public Serializable disassemble(final Object value)
            throws HibernateException {
        return (Serializable) value;
    }

    public boolean equals(final Object o1, final Object o2)
            throws HibernateException {
        boolean isEqual = false;
        if (o1 == o2) {
            isEqual = true;
        }
        if (null == o1 || null == o2) {
            isEqual = false;
        } else {
            isEqual = o1.equals(o2);
        }
        return isEqual;
    }

    public int hashCode(final Object arg0) throws HibernateException {
        return arg0.hashCode();
    }

    public boolean isMutable() {
        return true;
    }

    public Object nullSafeGet(final ResultSet resultSet, final String[] names,
                              SessionImplementor sessionImp, final Object jmbgOwner)
            throws HibernateException, SQLException {
        System.out.println("nullSafeGet...");
        //must write custom native query in repo for this to work with jmbg alias
        try {
            return new Jmbg(resultSet.getString("jmbg"));
        } catch (SQLException e) {
            return new Jmbg("unable-to-fetch");
        }
    }

    public void nullSafeSet(final PreparedStatement statement, final Object value, final int index,
                            SessionImplementor arg3) throws HibernateException, SQLException {
        if (value == null) {

            statement.setNull(index, SQL_TYPE, OBJECT_TYPE);

        } else {
            final Jmbg addresssData = (Jmbg) value;
            final Object[] values = new Object[]{addresssData.getJmbg()};
            final Connection connection = statement.getConnection();
            final STRUCT struct = new STRUCT(StructDescriptor.createDescriptor(OBJECT_TYPE, connection), connection, values);
            statement.setObject(index, struct, SQL_TYPE);

        }

    }

    public Object replace(final Object original, final Object target,
                          final Object owner) throws HibernateException {
        return this.deepCopy(original);
    }

    @SuppressWarnings("rawtypes")
    public Class returnedClass() {
        return Jmbg.class;
    }

    public int[] sqlTypes() {
        return new int[]{SQL_TYPE};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jmbg jmbg1 = (Jmbg) o;

        return jmbg != null ? jmbg.equals(jmbg1.jmbg) : jmbg1.jmbg == null;
    }

    @Override
    public int hashCode() {
        return jmbg != null ? jmbg.hashCode() : 0;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
}
