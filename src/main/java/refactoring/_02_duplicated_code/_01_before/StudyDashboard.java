package refactoring._02_duplicated_code._01_before;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class StudyDashboard {

    private void printParticipants(int eventId) throws IOException {
        // Get github issue to check homework
        GHIssue issue = getGhIssue(eventId);

        // Get participants
        Set<String> participants = getUsernames(issue);

        // Print participants
        print(participants);
    }

    private static void print(Set<String> participants) {
        participants.forEach(System.out::println);
    }

    private static Set<String> getUsernames(GHIssue issue) throws IOException {
        Set<String> usernames = new HashSet<>();
        issue.getComments().forEach(c -> usernames.add(c.getUserName()));
        return usernames;
    }

    private static GHIssue getGhIssue(int eventId) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        return repository.getIssue(eventId);
    }

    private void printReviewers() throws IOException {
        // Get github issue to check homework
        GHIssue issue = getGhIssue(30);

        // Get reviewers
        Set<String> reviewers = getUsernames(issue);

        // Print reviewers
        print(reviewers);
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.printReviewers();
        studyDashboard.printParticipants(15);

    }

}
