package Pong;


public class Paddle1 {
    private int paddle_y1;
    private int paddle_height=80;

    public int getPaddle_height() {
        return paddle_height;
    }

    public void setPaddle_height(int x) {
        paddle_height = x;
    }

    private int paddle_y_velocity1;

    public void move() {
        if (paddle_y_velocity1 == 0) {
            paddle_y_velocity1 *= .94;
        }
        paddle_y1 += paddle_y_velocity1;
        //Detecting collisions between paddles and walls.
        if (paddle_y1 < 6) {
            paddle_y1 = 6;
        }
        if (paddle_height == 80) {
            if (paddle_y1 > 378) {
                paddle_y1 = 378;
            }
        } else if (paddle_height == 110) {
            if (paddle_y1 > 348) {
                paddle_y1 = 348;
            }
        }
    }

    public int getPaddle_y1() {
        return paddle_y1;
    }

    public void setPaddle_y1(int x) {
        paddle_y1 = x;
    }

    public void setPaddle_y_velocity1(int x) {
        paddle_y_velocity1 = x;
    }
}
