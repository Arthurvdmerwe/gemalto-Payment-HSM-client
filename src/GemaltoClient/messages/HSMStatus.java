import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lekanomotayo on 20/04/2018.
 * HSM-STATUS (01)?
 */
public class HSMStatus extends HsmMsg {

    // ADVANCED-RANDOM-KEY-GENERATION (EE0619)

    protected static final String START_ = "010100000007";

    String ramStatus;
    String romStatus;
    String desStatus;
    String hostPortStatus;
    String batteryStatus;
    String hardDiskStatus;
    String rsaAccelerator;
    String performanceLevel;
    String resetCount;
    String callsInLastMin;
    String callsInLast10Min;
    String softwareIdLen;
    String softwareId;



    public HSMStatus(String sequenceNo){
        super(sequenceNo, "01", 1,null);
    }


    public byte[] pack()throws IOException{

        String body = functionCode;
        String messageLength = Integer.toHexString(body.length() / 2).toUpperCase();
        messageLength = padLeft(messageLength, 4, "0");
        String header = requestHeaderSohCharacter + requestHeaderVersion + requestSequenceNo + messageLength;

        String request = header + body;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(hexBinaryConverter.parseHexBinary(request));

        byte[] request_data = baos.toByteArray();
        ByteArrayOutputStream raw_data = new ByteArrayOutputStream();
        raw_data.write(request_data);
        requestData = raw_data.toByteArray();

        return requestData;
    }

    public void unpack(byte[] data){
        responseData = data;
        super.unpack(data);
//        String str_recvd = hexBinaryConverter.fromBinary2Hex(data);

        if("00".equalsIgnoreCase(errorCode)){

            byte[] ramStatusBytes = new byte[1];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen, ramStatusBytes, 0, 1);
            ramStatus = hexBinaryConverter.fromBinary2Hex(ramStatusBytes);

            byte[] romStatusBytes = new byte[1];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + 1, romStatusBytes, 0, 1);
            romStatus = hexBinaryConverter.fromBinary2Hex(romStatusBytes);

            byte[] desStatusBytes = new byte[1];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + 2, desStatusBytes, 0, 1);
            desStatus = hexBinaryConverter.fromBinary2Hex(desStatusBytes);

            byte[] hostPortStatusBytes = new byte[1];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + 3, hostPortStatusBytes, 0, 1);
            hostPortStatus = hexBinaryConverter.fromBinary2Hex(hostPortStatusBytes);

            byte[] batteryStatusBytes = new byte[1];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + 4, batteryStatusBytes, 0, 1);
            batteryStatus = hexBinaryConverter.fromBinary2Hex(batteryStatusBytes);

            byte[] hardDiskStatusBytes = new byte[1];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + 5, hardDiskStatusBytes, 0, 1);
            hardDiskStatus = hexBinaryConverter.fromBinary2Hex(hardDiskStatusBytes);

            byte[] rsaAcceleratorBytes = new byte[1];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + 6, rsaAcceleratorBytes, 0, 1);
            rsaAccelerator = hexBinaryConverter.fromBinary2Hex(rsaAcceleratorBytes);

            byte[] performanceLevelBytes = new byte[1];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + 7, performanceLevelBytes, 0, 1);
            performanceLevel = hexBinaryConverter.fromBinary2Hex(performanceLevelBytes);

            byte[] resetCountBytes = new byte[2];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + 8, resetCountBytes, 0, 2);
            resetCount = hexBinaryConverter.fromBinary2Hex(resetCountBytes);

            byte[] callsInLastMinBytes = new byte[4];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + 10, callsInLastMinBytes, 0, 4);
            callsInLastMin = hexBinaryConverter.fromBinary2Hex(callsInLastMinBytes);

            byte[] callsInLast10MinBytes = new byte[4];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + 14, callsInLast10MinBytes, 0, 4);
            callsInLast10Min = hexBinaryConverter.fromBinary2Hex(callsInLast10MinBytes);

            byte[] softwareIdLenBytes = new byte[1];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + 18, softwareIdLenBytes, 0, 1);
            softwareIdLen = hexBinaryConverter.fromBinary2Hex(softwareIdLenBytes);

            byte[] softwareIdBytes = new byte[Integer.parseInt(softwareIdLen)];
            System.arraycopy(data, messageHeaderLen + functionCodeByteLen + responseCodeByteLen + 19, softwareIdBytes, 0, Integer.parseInt(softwareIdLen));
            softwareId = new String(softwareIdBytes);

        }
    }

    @Override
    public String toString(){
        return super.toString() +
                "\nRAM Status: " +  ramStatus +
                "\nROM Status: " +  romStatus +
                "\nDES Status: " +  desStatus +
                "\nHost Port Status: " +  hostPortStatus +
                "\nBattery Status: " +  batteryStatus +
                "\nHard Disk Status: " +  hardDiskStatus +
                "\nRSA Accelerator Status: " +  rsaAccelerator +
                "\nPerformance Level: " +  performanceLevel +
                "\nReset Count: " +  resetCount +
                "\nCalls In Last Min: " +  callsInLastMin +
                "\nCalls in Last 10 Min: " +  callsInLast10Min +
                "\nSoftware ID: " +  softwareId;

    }

}
