package co.nambaone.prj.movie.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nambaone.prj.common.Command;

public class Categories implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "movie/categories.tiles";

	}

}
