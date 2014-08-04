package org.librairiejpa.dal;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the media database table.
 * 
 */
@Entity
@NamedQuery(name="Media.findAll", query="SELECT m FROM Media m")
public class Media implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="media_id")
	private Integer mediaId;

	@Column(name="media_musique")
	private String mediaMusique;

	@Column(name="media_video")
	private String mediaVideo;

	//bi-directional many-to-one association to Livre
	@OneToMany(mappedBy="media")
	private List<Livre> livres;

	public Media() {
	}

	public Integer getMediaId() {
		return this.mediaId;
	}

	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaMusique() {
		return this.mediaMusique;
	}

	public void setMediaMusique(String mediaMusique) {
		this.mediaMusique = mediaMusique;
	}

	public String getMediaVideo() {
		return this.mediaVideo;
	}

	public void setMediaVideo(String mediaVideo) {
		this.mediaVideo = mediaVideo;
	}

	public List<Livre> getLivres() {
		return this.livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	public Livre addLivre(Livre livre) {
		getLivres().add(livre);
		livre.setMedia(this);

		return livre;
	}

	public Livre removeLivre(Livre livre) {
		getLivres().remove(livre);
		livre.setMedia(null);

		return livre;
	}

}