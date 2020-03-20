package wang.miansen.printer.core;

/**
 * @author miansen.wang
 * @date 2020-03-20
 */
public class Configuration {

	private Boolean wildcard = true;
	
	private Boolean stopOnErrors = false;
	
	private Boolean mapNull = true;
	
	private Boolean mapEmptyString = true;

	public Boolean getWildcard() {
		return wildcard;
	}

	public void setWildcard(Boolean wildcard) {
		this.wildcard = wildcard;
	}

	public Boolean getStopOnErrors() {
		return stopOnErrors;
	}

	public void setStopOnErrors(Boolean stopOnErrors) {
		this.stopOnErrors = stopOnErrors;
	}

	public Boolean getMapNull() {
		return mapNull;
	}

	public void setMapNull(Boolean mapNull) {
		this.mapNull = mapNull;
	}

	public Boolean getMapEmptyString() {
		return mapEmptyString;
	}

	public void setMapEmptyString(Boolean mapEmptyString) {
		this.mapEmptyString = mapEmptyString;
	}

	@Override
	public String toString() {
		return "Configuration [wildcard=" + wildcard + ", stopOnErrors=" + stopOnErrors + ", mapNull=" + mapNull
				+ ", mapEmptyString=" + mapEmptyString + "]";
	}
	
}
