package org.wecancodeit.restingcities;

import javax.persistence.Embeddable;

@Embeddable
public class Fish {
	
	private String fishName;
	private String binomialNomenclature;
	private String imgUrl;
	
	public Fish() {}
	
	public Fish(String fishName, String binomialNomenclature, String imgUrl) {
		this.fishName = fishName;
		this.binomialNomenclature = binomialNomenclature;
		this.imgUrl = imgUrl;
	}

	public String getFishName() {
		return fishName;
	}

	public String getBinomialNomenclature() {
		return binomialNomenclature;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	@Override
	public String toString() {
		return fishName;
	}

}
