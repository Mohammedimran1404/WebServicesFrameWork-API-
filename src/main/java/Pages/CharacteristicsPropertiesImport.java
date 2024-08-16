package Pages;

public class CharacteristicsPropertiesImport {

    private int loadErrorCode;
    private String fileOutput;
    private String stdoutOutput;

    public int getLoadErrorCode(){
        return loadErrorCode;
    }
    public void setLoadErrorCode(int loadErrorCode){
        this.loadErrorCode=loadErrorCode;
    }
    public String getFileOutput(){
        return fileOutput;
    }
    public void setFileOutput(String fileOutput){
        this.fileOutput=fileOutput;
    }
    public String getStdoutOutput(){
        return stdoutOutput;
    }
    public void setStdoutOutput(String stdoutOutput){
        this.stdoutOutput=stdoutOutput;
    }
    @Override
    public String toString(){
        return "ClassPojo [loadErrorCode = "+loadErrorCode+", fileOutput ="+fileOutput+", stdoutOutput ="+stdoutOutput+"]";

    }
}
