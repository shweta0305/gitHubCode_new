package github.pageObject;

import java.io.IOException;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class ViaAPI {
	@SuppressWarnings("deprecation")
	public void createRepoUsingApi() {
		try {
			GitHub github = GitHub.connectUsingPassword("qaitautomation", "Nikhil-101");
			GHRepository repo = github.createRepository("new Repo", "initial commit", "xyz", true);
			System.out.println(repo.getUrl());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}