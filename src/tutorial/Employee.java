/**
 * Automatically generated by Zserio Java extension version 1.3.0.
 */

package tutorial;

import javax.annotation.Generated;
import java.io.IOException;
import java.io.File;
import zserio.runtime.SizeOf;
import zserio.runtime.io.BitStreamReader;
import zserio.runtime.io.FileBitStreamReader;
import zserio.runtime.ZserioError;
import zserio.runtime.Util;
import zserio.runtime.io.BitStreamWriter;
import zserio.runtime.io.FileBitStreamWriter;
import zserio.runtime.io.InitializeOffsetsWriter;
import zserio.runtime.ConstraintError;
import zserio.runtime.BitSizeOfCalculator;

@Generated(
    value = "zserio.tools.ZserioTool",
    comments = "generated by Zserio Java extension version 1.3.0"
)
public class Employee implements InitializeOffsetsWriter, SizeOf
{
    public Employee()
    {
    }

    public Employee(File __file) throws IOException, ZserioError
    {
        final FileBitStreamReader __in = new FileBitStreamReader(__file);
        read(__in);
        __in.close();
    }

    public Employee(BitStreamReader __in) throws IOException, ZserioError
    {
        read(__in);
    }

    public Employee(
        short age,
        String name,
        int salary,
        Integer bonus,
        tutorial.Role role,
        zserio.runtime.array.ObjectArray<tutorial.Experience> skills)
    {
        setAge(age);
        setName(name);
        setSalary(salary);
        setBonus(bonus);
        setRole(role);
        setSkills(skills);
    }

    @Override
    public int bitSizeOf()
    {
        return bitSizeOf(0);
    }

    @Override
    public int bitSizeOf(long __bitPosition)
    {
        long __endBitPosition = __bitPosition;

        __endBitPosition += 8;
        __endBitPosition += BitSizeOfCalculator.getBitSizeOfString(getName());
        __endBitPosition += 16;
        __endBitPosition += 1;
        if (bonus != null)
        {
            __endBitPosition += 16;
        }
        __endBitPosition += getRole().bitSizeOf(__endBitPosition);
        if (getRole() == tutorial.Role.DEVELOPER)
        {
            __endBitPosition += getSkills().bitSizeOfAuto(__endBitPosition);
        }

        return (int)(__endBitPosition - __bitPosition);
    }

    public short getAge()
    {
        return this.age;
    }

    public void setAge(short age)
    {
        this.age = age;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getSalary()
    {
        return this.salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public Integer getBonus()
    {
        return this.bonus;
    }

    public void setBonus(Integer bonus)
    {
        this.bonus = bonus;
    }

    public boolean hasBonus()
    {
        return (bonus != null);
    }

    public tutorial.Role getRole()
    {
        return this.role;
    }

    public void setRole(tutorial.Role role)
    {
        this.role = role;
    }

    public zserio.runtime.array.ObjectArray<tutorial.Experience> getSkills()
    {
        return this.skills;
    }

    public void setSkills(zserio.runtime.array.ObjectArray<tutorial.Experience> skills)
    {
        this.skills = skills;
    }

    public void setSkills(java.util.List<tutorial.Experience> skills)
    {
        this.skills = new zserio.runtime.array.ObjectArray<tutorial.Experience>(skills);
    }

    public boolean hasSkills()
    {
        return (getRole() == tutorial.Role.DEVELOPER);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Employee)
        {
            final Employee __that = (Employee)obj;

            return
                    this.age == __that.age &&
                    ((this.name == null) ? __that.name == null : this.name.equals(__that.name)) &&
                    this.salary == __that.salary &&
                    ((this.bonus == null) ? __that.bonus == null : this.bonus.equals(__that.bonus)) &&
                    ((this.role == null) ? __that.role == null : this.role.getValue() == __that.role.getValue()) &&
                    (!(getRole() == tutorial.Role.DEVELOPER) ||
                    ((this.skills == null) ? __that.skills == null : this.skills.equals(__that.skills)));
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        int __result = Util.HASH_SEED;

        __result = Util.HASH_PRIME_NUMBER * __result + age;
        __result = Util.HASH_PRIME_NUMBER * __result + ((name == null) ? 0 : name.hashCode());
        __result = Util.HASH_PRIME_NUMBER * __result + salary;
        __result = Util.HASH_PRIME_NUMBER * __result + ((bonus == null) ? 0 : bonus.hashCode());
        __result = Util.HASH_PRIME_NUMBER * __result + ((role == null) ? 0 : role.hashCode());
        if (getRole() == tutorial.Role.DEVELOPER)
            __result = Util.HASH_PRIME_NUMBER * __result + ((skills == null) ? 0 : skills.hashCode());

        return __result;
    }

    public void read(final BitStreamReader __in) throws IOException, ZserioError
    {
        age = (short)__in.readUnsignedByte();

        name = __in.readString();

        salary = __in.readUnsignedShort();

        if (__in.readBool())
        {
            bonus = __in.readUnsignedShort();
        }

        role = tutorial.Role.readEnum(__in);

        if (getRole() == tutorial.Role.DEVELOPER)
        {
            skills = new zserio.runtime.array.ObjectArray<tutorial.Experience>(__in, zserio.runtime.array.Array.AUTO_LENGTH,
                new __ElementFactory_skills());
        }

        __checkConstraints();
    }

    public long initializeOffsets(long __bitPosition)
    {
        long __endBitPosition = __bitPosition;

        __endBitPosition += 8;
        __endBitPosition += BitSizeOfCalculator.getBitSizeOfString(getName());
        __endBitPosition += 16;
        __endBitPosition += 1;
        if (bonus != null)
        {
            __endBitPosition += 16;
        }
        __endBitPosition += getRole().bitSizeOf(__endBitPosition);
        if (getRole() == tutorial.Role.DEVELOPER)
        {
            __endBitPosition = getSkills().initializeOffsetsAuto(__endBitPosition);
        }

        return __endBitPosition;
    }

    public void write(File __file) throws IOException, ZserioError
    {
        FileBitStreamWriter __out = new FileBitStreamWriter(__file);
        write(__out);
        __out.close();
    }

    @Override
    public void write(BitStreamWriter __out) throws IOException, ZserioError
    {
        write(__out, true);
    }

    @Override
    public void write(BitStreamWriter __out, boolean __callInitializeOffsets) throws IOException, ZserioError
    {
        __checkConstraints();
        __out.writeUnsignedByte(getAge());

        __out.writeString(getName());

        __out.writeUnsignedShort(getSalary());

        if (bonus != null)
        {
            __out.writeBool(true);
            __out.writeUnsignedShort(getBonus());
        }
        else
        {
            __out.writeBool(false);
        }

        getRole().write(__out, false);

        if (getRole() == tutorial.Role.DEVELOPER)
        {
            getSkills().writeAuto(__out);
        }
    }

    private void __checkConstraints() throws ZserioError
    {
        if (!(getAge() <= 65))
            throw new ConstraintError("Constraint violated at Employee.age!");
    }

    private static final class __ElementFactory_skills implements zserio.runtime.array.ElementFactory<tutorial.Experience>
    {
        @Override
        public tutorial.Experience create(BitStreamReader __in, int __index)
            throws IOException, ZserioError
        {
            return new tutorial.Experience(__in);
        }
    }

    private short age;
    private String name;
    private int salary;
    private Integer bonus;
    private tutorial.Role role;
    private zserio.runtime.array.ObjectArray<tutorial.Experience> skills;
}
