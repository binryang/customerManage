package domain;

/**
 * Created by yangrb on 17-7-20.
 */
public class CriteriaCustomer {
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String description;

    public String getName() {
        if (name==null){
            name = "%%";
        }
        else{
            name = "%"+name+"%";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        if (gender==null){
            gender = "%%";
        }
        return gender;
    }

    public void setGender(String gender) {
        this.gender=gender;
    }

    public String getPhone() {
        if (phone == null){
            phone = "%%";
        }
        else{
            phone = "%"+phone+"%";
        }
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        if (email == null){
            email = "%%";
        }
        else{
            email = "%"+email+"%";
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        if (description == null){
            description = "%%";
        }
        else{
            description = "%"+description+"%";
        }
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public CriteriaCustomer() {
    }


    public CriteriaCustomer(String name, String gender, String phone, String email, String description) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    @Override
    public String toString() {
        return "CriteriaCustomer{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

