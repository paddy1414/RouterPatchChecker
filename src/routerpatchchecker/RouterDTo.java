/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routerpatchchecker;

/**
 *
 * @author Patrick
 */

import java.util.Objects;

/**
 *
 * @author Patrick
 */
public class RouterDTo {
    String hostName;
    String ipAddress;
    String ifPatched;
    double osVersion;
    String notes = "blank";

    public RouterDTo(String hostName, String ipAddress, String ifPatched, double osVersion, String notes) {
        this.hostName = hostName;
        this.ipAddress = ipAddress;
        this.ifPatched = ifPatched;
        this.osVersion = osVersion;
        this.notes = notes;
    }  
    public RouterDTo(String hostName, String ipAddress, String ifPatched, double osVersion) {
        this.hostName = hostName;
        this.ipAddress = ipAddress;
        this.ifPatched = ifPatched;
        this.osVersion = osVersion;
    } 
    public RouterDTo() {
        this.hostName = "";
        this.ipAddress = "";
        this.ifPatched = "";
        this.osVersion = 0;
    }

    
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIfPatched() {
        return ifPatched;
    }

    public void setIfPatched(String ifPatched) {
        this.ifPatched = ifPatched;
    }

    public double getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(double osVersion) {
        this.osVersion = osVersion;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.hostName);
        hash = 37 * hash + Objects.hashCode(this.ipAddress);
        hash = 37 * hash + Objects.hashCode(this.ifPatched);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.osVersion) ^ (Double.doubleToLongBits(this.osVersion) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.notes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RouterDTo other = (RouterDTo) obj;
        if (Double.doubleToLongBits(this.osVersion) != Double.doubleToLongBits(other.osVersion)) {
            return false;
        }
        if (!Objects.equals(this.hostName, other.hostName)) {
            return false;
        }
        if (!Objects.equals(this.ipAddress, other.ipAddress)) {
            return false;
        }
        if (!Objects.equals(this.ifPatched, other.ifPatched)) {
            return false;
        }
        if (!Objects.equals(this.notes, other.notes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RouterDTo{" + "hostName=" + hostName + ", ipAddress=" + ipAddress + ", ifPatched=" + ifPatched + ", osVersion=" + osVersion + ", notes=" + notes + '}';
    }

   
    
    
    
    
    
    
    
    
}
