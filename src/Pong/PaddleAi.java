package Pong;

public class PaddleAi {
    private int paddleA_y = 210;

    Ball b1;
    Paddle1 p1 = new Paddle1();

    public PaddleAi(Ball b) {
        b1 = b;
    }

    public void move(int x, int level) {
        if (level != 3) {//paddle movement
            if (paddleA_y + 30 < b1.getBall_y()) {
                paddleA_y += x;
            } else if (paddleA_y + 20 > b1.getBall_y()) {
                paddleA_y -= x;
            }
        } else if (level == 3) {
            paddleA_y = (int) (b1.getBall_y() - 40);//paddle movement for hard level
        }
//        Detecting collisions between paddles and walls.
        if (paddleA_y < 6) {
            paddleA_y = 6;
        }
        if (p1.getPaddle_height() == 80) {
            if (paddleA_y > 378) {
                paddleA_y = 378;
            }
        } else if (p1.getPaddle_height() == 110) {
            if (paddleA_y > 348) {
                paddleA_y = 348;
            }
        }
    }

    public int getPaddleA_y() {
        return paddleA_y;
    }

    public void setPaddleA_y(int x) {
        paddleA_y = x;
    }

}
