package Pong;

public class Paddle2 {
    private int paddle_y2;
    private int paddle_y_velocity2;
    public int getPaddle_y_velocity2() {
        return paddle_y_velocity2;
    }

    Paddle1 p1 = new Paddle1();

    public void move() {
        if (paddle_y_velocity2 == 0) {
            paddle_y_velocity2 *= .94;
        }
        paddle_y2 += paddle_y_velocity2;
        //Detecting collisions between paddles and walls.
        if (paddle_y2 < 6) {
            paddle_y2 = 6;
        }
        if (p1.getPaddle_height() == 80) {
            if (paddle_y2 > 378) {
                paddle_y2 = 378;
            }
        } else if (p1.getPaddle_height() == 110) {
            if (paddle_y2 > 348) {
                paddle_y2 = 348;
            }
        }
    }

    public int getPaddle_y2() {
        return paddle_y2;
    }

    public void setPaddle_y2(int x) {
        paddle_y2 = x;
    }
    public void setPaddle_y_velocity2(int x) {
        paddle_y_velocity2 = x;
    }
}
