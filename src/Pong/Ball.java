package Pong;

import java.util.Random;

public class Ball {
    private double ball_x, ball_y, ball_x_Velocity, ball_y_Velocity,add=0.4,max=10.5;
    private int Left_Score = 0, speed;
    private int Right_Score = 0;
    Paddle1 p1 = new Paddle1();
    Game game;
    SoundEffect sound = new SoundEffect();
    Paddle2 p2;
    Random random = new Random();
    public void move() {//The movement of the ball.
        //Changing the position of the ball's x and limit coordinates.
        ball_x += ball_x_Velocity;
        ball_y += ball_y_Velocity;
        //Detecting collisions between the ball and the walls.
        if (ball_y < 22) {
            sound.HitBall();
            ball_y_Velocity = -ball_y_Velocity;
        }
        if (ball_y > 460) {
            sound.HitBall();
            ball_y_Velocity = -ball_y_Velocity;
        }
    }
    public boolean check_goal() {
        p2 = new Paddle2();
        if (ball_x < 30) {//Score for the right paddle
            sound.Goal();
            Right_Score++;
            ball_x = 350;
            ball_y = random.nextInt(300) + 100;
            speed = random.nextInt(2) + 4;
            ball_x_Velocity = random.nextInt(2);
            if (ball_x_Velocity == 0) {
                ball_x_Velocity -= 1;
            }
            ball_y_Velocity = random.nextInt(2);
            if (ball_y_Velocity == 0) {
                ball_y_Velocity -= 1;
            }
            ball_y_Velocity *= speed;
            ball_x_Velocity *= speed;
            return true;
        }
        if (ball_x > 660) {//Score for the left paddle
            sound.Goal();
            Left_Score++;
            ball_x = 350;
            ball_y = random.nextInt(300) + 100;
            speed = random.nextInt(2) + 4;
            ball_x_Velocity = random.nextInt(2);
            if (ball_x_Velocity == 0) {
                ball_x_Velocity -= 1;
            }
            ball_y_Velocity = random.nextInt(2);
            if (ball_y_Velocity == 0) {
                ball_y_Velocity -= 1;
            }
            ball_y_Velocity *= speed;
            ball_x_Velocity *= speed;
            return true;
        }
        return false;
    }
    public void check_paddle_collision(int L_P_collision, int R_P_collision) {//Detecting collisions between the ball and the paddles.
        game = new Game();
        if (ball_x < 60) {
            if (ball_y > L_P_collision && ball_y < L_P_collision+p1.getPaddle_height()+3) {
                sound.HitBall();
                ball_x_Velocity *= -1;
                if(Math.abs(ball_x_Velocity)<max){
                    ball_x_Velocity+=add;
                }
            }
        } else if (ball_x > 650) {
            if (ball_y > R_P_collision && ball_y < R_P_collision + p1.getPaddle_height()+3) {
                sound.HitBall();
                ball_x_Velocity *= -1;
                if(Math.abs(ball_x_Velocity)<max){
                    ball_x_Velocity-=add;
                }
            }
        }
    }

    public double getBall_x() {
        return ball_x;
    }

    public void setBall_x(double x) {
        ball_x = x;
    }

    public double getBall_y() {
        return ball_y;
    }

    public void setBall_y(double x) {
        ball_y = x;
    }

    public double getBall_x_Velocity() {
        return ball_x_Velocity;
    }

    public void setBall_x_Velocity(double x) {
        ball_x_Velocity = x;
    }

    public double getBall_y_Velocity() {
        return ball_y_Velocity;
    }

    public void setBall_y_Velocity(double x) {
        ball_y_Velocity = x;
    }

    public int getLeft_Score() {
        return Left_Score;
    }

    public int getRight_Score() {
        return Right_Score;
    }

    public void setspeed(int x) {
        speed = x;
    }

    public int getspeed() {
        return speed;
    }
}
