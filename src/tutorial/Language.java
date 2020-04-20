/**
 * Automatically generated by Zserio Java extension version 1.4.0.
 */

package tutorial;

import javax.annotation.Generated;
import java.io.IOException;
import zserio.runtime.SizeOf;
import zserio.runtime.ZserioEnum;
import zserio.runtime.ZserioError;
import zserio.runtime.io.BitStreamReader;
import zserio.runtime.io.BitStreamWriter;
import zserio.runtime.io.InitializeOffsetsWriter;

@Generated(
    value = "zserio.tools.ZserioTool",
    comments = "generated by Zserio Java extension version 1.4.0"
)
public enum Language implements InitializeOffsetsWriter, SizeOf, ZserioEnum
{
    CPP((byte)0),
    JAVA((byte)1),
    PYTHON((byte)2),
    JS((byte)3);

    private Language(byte __value)
    {
        this.__value = __value;
    }

    public byte getValue()
    {
        return __value;
    }

    @Override
    public Number getGenericValue()
    {
        return __value;
    }

    @Override
    public int bitSizeOf()
    {
        return bitSizeOf(0);
    }

    @Override
    public int bitSizeOf(long __bitPosition)
    {
        return 2;
    }

    @Override
    public long initializeOffsets(long __bitPosition) throws ZserioError
    {
        return __bitPosition + bitSizeOf(__bitPosition);
    }

    @Override
    public void write(BitStreamWriter __out) throws IOException
    {
        write(__out, false);
    }

    @Override
    public void write(BitStreamWriter __out, boolean __callInitializeOffsets) throws IOException
    {
        __out.writeBits(getValue(), 2);
    }

    public static Language readEnum(BitStreamReader __in) throws IOException
    {
        return toEnum((byte)__in.readBits(2));
    }

    public static Language toEnum(byte __value)
    {
        switch (__value)
        {
            case (byte)0:
                return CPP;
            case (byte)1:
                return JAVA;
            case (byte)2:
                return PYTHON;
            case (byte)3:
                return JS;
            default:
                throw new IllegalArgumentException("Unknown value for enumeration Language: " + __value + "!");
        }
    }

    private byte __value;
}
