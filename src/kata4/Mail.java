package kata4;

class Mail {

    private String address;

    public Mail(String address) {
        this.address = address;
    }

    Mail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAddress() {
        return address;
    }
    
    public String getDomain(){
        return address.split("@")[1];
    }
    
}
