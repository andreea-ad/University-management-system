public class Faculty {
    int id;
    String title;
    public Faculty(int id, String title){
        setID(id);
        setTitle(title);
    }
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String toString(){
        return title;
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Faculty) {
            Faculty other = (Faculty) o;
            return title.equals(((Faculty) o).getTitle());
        }
        return false;
    }
    @Override
    public int hashCode(){
        return title.hashCode();
    }
}
