package quizproblem;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.catalina.SessionIdGenerator;

/***
 * 
 * This is our main class where we accept GET, POST requests
 * GET -> For fetching the questions to user 
 * POST -> For receiving user Answers and checking that the answer provided by user is right or wrong
 */


@WebServlet("/quiz")
public class App extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		Generating n Question with random values & with difficulty level
		Question[] questions = Question.generateQuestions(5,2);
		
//		receiving the user session
		HttpSession session = req.getSession(true);
		
//		storing questions to user session
		session.setAttribute("questions", questions);
		
//		dispatching the request to index.jsp page to user
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession(false);
		
//		If session is invalidate then we redirect user to http://localhost:9090/QuizProblem/quiz
		if(session != null) {
//			getting Question objects from session
			Question[] questions = (Question[]) session.getAttribute("questions");
			
//			this function validates the user answers with the right one
			matchAnswers(questions, req);
			
			int correctCount = getCorrectCount(questions);
//			storing results to request object to pass further
			req.setAttribute("results", questions);
			req.setAttribute("correctCount", correctCount);
			
//			invalidating the session so that we did not receive the previous results again
			session.invalidate();
			
//			dispatching the request response object to /result to show the result to user
			req.getRequestDispatcher("/result").forward(req, res);
			
		}else {
			res.sendRedirect("/quiz");
		}
		
	}
	static int getCorrectCount(Question[] questions) {
		int correctCount = 0;
		for(Question q : questions) {
			if(q.getResult().equals("Correct")) {
				correctCount++;
			}
		}
		return correctCount;
	}
	
	static void matchAnswers(Question[] questions, HttpServletRequest req) {
//		iterating over every single question to match with the user answer
		for(Question q : questions) {
//			receiving user answer from input field
			String str = req.getParameter("inp"+q.getId());
			
//			if user input is null then set it wrong and continue
			if(str == null || str == "") {
				q.setResult("Wrong");
				continue;
			}
			
//			String to long
			long userAns = Long.parseLong(str);
			
//			validating the user answer with right answer stored in Question object
			if(q.getAnswer() == userAns) {
				q.setResult("Correct");
				q.setUserAns(userAns);
			}else {
				q.setResult("Wrong");
				q.setUserAns(userAns);
			}
		}
	}
	
}
