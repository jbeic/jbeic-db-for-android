package annotation;

public class App implements MyDelete {

    @MethodInfo(
        author = "trinea.cn+android@gmail.com",
        date = "2014/02/14",
        version = 2)
    public String getAppName() {
        return "trinea";
    }
    @IsKeyFiled(isfiled =true)
    public  int  id;
    @IsDeleteFiled(isfiled =true)
    public  int  age;
    @IsDeleteFiled(isfiled =true)
    public  int  name;
    @IsDeleteFiled(isfiled =true)
    public  int  key;
    @IsDeleteFiled(isfiled =true)
    public  int  student;
    
    @MethodInfo(
            author = "trinea.cn+android@gmail.com",
            date = "2014/02/14",
            version = 2)
    public void delete() {
       System.err.println("Ö´ÐÐÉ¾³ý");
    }
}
//Jbeic