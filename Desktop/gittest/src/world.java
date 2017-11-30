public class world {
    public String name;
    public world(){
        this.name= "Earth";
    }
    public world(String name){
        this.name = name;
    }
    public void say(){
        System.out.println("Hey, from " + this.name);
    }
}