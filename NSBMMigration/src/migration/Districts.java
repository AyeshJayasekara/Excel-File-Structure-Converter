/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migration;

/**
 *
 * @author ejkpa
 */
public enum Districts {
    
 AD("Anuradhapura","North Central Province")
,APR("Ampara","Eastern Province")
,BC("Batticaloa","Eastern Province")
,BD("Badulla","Uva Province")
,BDD("","")
,CO("Colombo","Western Province")
,GL("Galle","Southern Province")
,GQ("Gampaha","Western Province")
,HB("Hambantota","Southern Province")
,JA("Jaffna","Northern Province")
,KE("Kegalle","Sabaragamuwa Province")
,KG("Kurunegala","North Western Province")
,KT("Kalutara","Western Province")
,KY("Kandy","Central Province")
,MB("Mannar","Northern Province")
,MH("Matara","Southern Province")
,MJ("Monaragala","Uva Province")
,MP("Mullativu","Northern Province")
,MT("Matale","Central Province")
,NW("Nuwara Eliya","Central Province")
,PR("Polonnaruwa","North Central Province")
,PX("Puttalam","North Western Province")
,RN("Ratnapura","Sabaragamuwa Province")
,TC("Trincomalee","Eastern Provice")
,VA("Vavuniya","Northern Province");

    private final String Dis;
    private final String Prov;

    private Districts(String Dis,String Pro) {
        this.Dis = Dis;
        this.Prov=Pro;
    }

    public String getDis() {
        return Dis;
    }

    public String getProv() {
        return Prov;
    }
    
};
