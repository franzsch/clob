package de.eier.clueb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Rating entity.
 *
 * @author Oliver Rövekamp
 */
@Entity
public class Rating extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -8602561360329162570L;

	@Column(name = "name")
	private String name;
	
	@OneToOne
	@PrimaryKeyJoinColumn
    private Activity activity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}
