
package week08files;

/**
 *
 * @author Gregory Safko
 */
public class FlashCards {
	private String face;
	private String answer;
	private int points;
	
	public FlashCards(){
		face = null;
		answer = null;
		points = 0;
	}
	
	public FlashCards(String face, String answer, int points) {
		this.face = face;
		this.answer = answer;
		this.points = points;
	}

	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	@Override
	public String toString(){
		return "face: " + face + "\nanswer: " + answer + "\npoints: " + points;
	}

}
