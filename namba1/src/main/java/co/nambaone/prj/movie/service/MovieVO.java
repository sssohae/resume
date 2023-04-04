package co.nambaone.prj.movie.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieVO {
	private int movieCode;
	private String movieTitle;
	private String movieDirector;
	private String movieActor;
	private String movieGenre;
	private Date movieOpeningDate;
	private String movieNation;
	private String movieTeaser;
	private String moviePoster;
	private String movieOverview;
	private int movieScore;
	private int movieHit;

	// 오티티서비스등록삭제일
	private Date movieStartDate;
	private Date movieEndDate;
}