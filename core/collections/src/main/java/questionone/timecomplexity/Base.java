package questionone.timecomplexity;

public class Base {
    private Integer id;
    private String name;

    public Base() {
    }

    public Base(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String toString() {
        return this.id + "," + this.name;
    }

    public static Base convert(String str) {
        String[] strObj = str.split(",");
        Base base = new Base();
        base.setId(Integer.valueOf(strObj[0]));
        return base;
    }
}
