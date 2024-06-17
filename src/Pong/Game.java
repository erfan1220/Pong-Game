package Pong;

import java.awt.*;
import java.util.Random;

public class Game {
    //===============================================
    private boolean game_over = true, HideBall = false;
    private Random random = new Random();
    private int R_P_collision, L_P_collision;
    private int paddle_x = 20, paddle_x2 = 650, LeftSC, BallSC, RightSC, side;
    private int food_x, food_y, ball_radius = 20, power_draw = 0, choice_background;
    private int food_y2, food_x2, power_draw2 = 0, easynum, mediumnum, Emove = 5, Mmove = 5;
    private long show_time, show_time2, easytime, mediumtime;
    private long hide_time = 0;
    //=======================================================
    SimpleGameWindow ta = new SimpleGameWindow();
    Paddle1 p1 = new Paddle1();
    Paddle2 p2 = new Paddle2();
    Ball b1 = new Ball();
    PaddleAi pa = new PaddleAi(b1);
    SoundEffect sound = new SoundEffect();

    //==========================================================
    public void run() {
        //Creating a game panel with a width of 700 and a height of 500, named "Ping" using the SimpleGameWindow class.
        ta.SimpleGameWindow1(700, 500, "Pong");
        Color my_red = new Color(255, 102, 102);//New special color for menu
        //Displaying the game menu on the screen and confirming user selection within the for loop in lines 34-47
        for (; ; ) {
            ta.clear();
            ta.drawSimpleString("1. Play Against the Computer", 220, 200, my_red, 20);
            ta.drawSimpleString("2. Two Player Pong Game", 220, 250, my_red, 20);
            ta.drawSimpleString("3. EXIT", 220, 300, my_red, 20);
            ta.drawSimpleString("*Use W,S,UP and DOWN keys for move", 170, 400, my_red, 20);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (ta.start() == 20 || ta.start() == -20) {
                break;
            }
        }
        //If the user selects single-player mode, we confirm the user's preferred side within the for loop. You should note that the for loop is controlled by the key listener that updated in SimpleGameWindow class.
        if (ta.start() == 20) {
            for (; ; ) {
                ta.clear();
                ta.drawSimpleString("Choose your side:", 260, 200, my_red, 20);
                ta.drawSimpleString("1.Left Paddle", 260, 250, my_red, 20);
                ta.drawSimpleString("2.Right Paddle", 260, 300, my_red, 20);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (ta.set_place() != 0) {
                    break;
                }
            }
            for (; ; ) {
                ta.clear();
                ta.drawSimpleString("Level:", 300, 200, my_red, 20);
                ta.drawSimpleString("1.Easy", 300, 250, my_red, 20);
                ta.drawSimpleString("2.Medium", 300, 300, my_red, 20);
                ta.drawSimpleString("3.Hard", 300, 350, my_red, 20);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (ta.level() != 0) {
                    break;
                }
            }
        }
        //Creating the color black for the paddles, ball, and background, which will change upon user selection.
        Color paddleL = new Color(0, 0, 0);
        Color ball = new Color(0, 0, 0);
        Color paddleR = new Color(0, 0, 0);
        Color background = new Color(0, 0, 0);
        Color my_orange = new Color(255, 128, 0);//New special color for menu
        Color gold = new Color(255, 215, 0);//New special color for menu
        //Creating multiple for loops similar to the menu loops for selecting the colors of the paddles, ball, and background, which still rely on key listener input for confirming user selection.
        for (; ; ) {
            ta.clear();
            ta.drawSimpleString("Chose the color of left paddle:", 220, 100, gold, 20);
            ta.drawSimpleString("1. white", 300, 150, Color.white, 20);
            ta.drawSimpleString("2. orange", 300, 200, my_orange, 20);
            ta.drawSimpleString("3. blue", 300, 250, Color.blue, 20);
            ta.drawSimpleString("4. red", 300, 300, Color.red, 20);
            ta.drawSimpleString("5. green", 300, 350, Color.green, 20);
            ta.drawSimpleString("6. yellow", 300, 400, Color.yellow, 20);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (ta.set_color() != 0) {
                break;
            }
        }//end of first loop
        for (; ; ) {
            ta.clear();
            ta.drawSimpleString("Chose the color ball :", 250, 100, gold, 20);
            ta.drawSimpleString("1. white", 300, 150, Color.white, 20);
            ta.drawSimpleString("2. green", 300, 200, Color.green, 20);
            ta.drawSimpleString("3. red", 300, 250, Color.red, 20);
            ta.drawSimpleString("4. sky blue", 300, 300, Color.cyan, 20);
            ta.drawSimpleString("5. yellow", 300, 350, Color.yellow, 20);
            ta.drawSimpleString("6. orange", 300, 400, my_orange, 20);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (ta.set_color2() != 0) {
                break;
            }
        }//end of second loop
        for (; ; ) {
            ta.clear();
            ta.drawSimpleString("Chose the color right paddle :", 220, 100, gold, 20);
            ta.drawSimpleString("1. white", 300, 150, Color.white, 20);
            ta.drawSimpleString("2. orange", 300, 200, my_orange, 20);
            ta.drawSimpleString("3. blue", 300, 250, Color.blue, 20);
            ta.drawSimpleString("4. red", 300, 300, Color.red, 20);
            ta.drawSimpleString("5. green", 300, 350, Color.green, 20);
            ta.drawSimpleString("6. yellow", 300, 400, Color.yellow, 20);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (ta.set_color3() != 0) {
                break;
            }
        }//end of third loop
        for (; ; ) {
            ta.clear();
            ta.drawSimpleString("Please select the background color :", 190, 100, gold, 20);
            ta.drawSimpleString("1. blue", 300, 150, Color.blue, 20);
            ta.drawSimpleString("2. red", 300, 200, Color.red, 20);
            ta.drawSimpleString("3. black", 300, 250, Color.white, 20);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (ta.set_background_color() != 0) {
                break;
            }
        }//end the fourth loop
        for(;;){//The loop to start the game.
            ta.clear();
            ta.drawSimpleString("Press the Enter key to start the game.",110,250,Color.white,30);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(ta.gamestart() == 1){
                break;
            }
        }
        LeftSC = ta.set_color();//Determining the user-selected color for the left paddle.
        BallSC = ta.set_color2();//Determining the user-selected color for the ball.
        RightSC = ta.set_color3();//Determining the user-selected color for the right paddle.
        side = ta.set_place();//Determining the user-selected side for the paddle.
        choice_background = ta.set_background_color();//Determining the user-selected color for the background.
        //Matching the selected colors with variables in lines 153_203.
        if (LeftSC == 1) {
            paddleL = new Color(255, 255, 255);
        } else if (LeftSC == 2) {
            paddleL = new Color(255, 128, 0);
        } else if (LeftSC == 3) {
            paddleL = new Color(0, 0, 255);
        } else if (LeftSC == 4) {
            paddleL = new Color(255, 0, 0);
        } else if (LeftSC == 5) {
            paddleL = new Color(0, 255, 0);
        } else if (LeftSC == 6) {
            paddleL = new Color(255, 255, 0);
        }
        //-------
        if (BallSC == 1) {
            ball = new Color(255, 255, 255);
        } else if (BallSC == 2) {
            ball = new Color(0, 255, 0);
        } else if (BallSC == 3) {
            ball = new Color(255, 0, 0);
        } else if (BallSC == 4) {
            ball = new Color(0, 255, 255);
        } else if (BallSC == 5) {
            ball = new Color(255, 255, 0);
        } else if (BallSC == 6) {
            ball = new Color(255, 128, 0);
        }
        //-------
        if (RightSC == 1) {
            paddleR = new Color(255, 255, 255);
        } else if (RightSC == 2) {
            paddleR = new Color(255, 128, 0);
        } else if (RightSC == 3) {
            paddleR = new Color(0, 0, 255);
        } else if (RightSC == 4) {
            paddleR = new Color(255, 0, 0);
        } else if (RightSC == 5) {
            paddleR = new Color(0, 255, 0);
        } else if (RightSC == 6) {
            paddleR = new Color(255, 255, 0);
        }
        //---------
        if (choice_background == 1) {
            background = new Color(0, 0, 255);
        } else if (choice_background == 2) {
            background = new Color(255, 0, 0);
        }
        //An initial random location is determined for the ball, and a random number between zero and one is obtained for the ball's x&limit velocity if it's zero, we subtract one from it and then multiply ball's x&limit velocity by the speed.Also, the ball's speed is itself a random number between 5, 6, and 7.
        //We multiply ball's x&limit velocity by the speed because 1 and -1 are small numbers that create slow movement for the ball.
        p1.setPaddle_y1(210);
        p2.setPaddle_y2(210);
        b1.setBall_x(360);
        b1.setBall_y(random.nextInt(300) + 100);
        b1.setspeed(random.nextInt(2) + 4);
        b1.setBall_x_Velocity(random.nextInt(2));
        if (b1.getBall_x_Velocity() == 0) b1.setBall_x_Velocity(-1);
        b1.setBall_y_Velocity(random.nextInt(2));
        if (b1.getBall_y_Velocity() == 0) b1.setBall_y_Velocity(-1);
        b1.setBall_y_Velocity(b1.getBall_y_Velocity() * b1.getspeed());
        b1.setBall_x_Velocity(b1.getBall_x_Velocity() * b1.getspeed());
        //Saving the time for the power_ups.
        show_time = System.currentTimeMillis();
        show_time2 = System.currentTimeMillis();
        //Saving time for the levels
        easytime = System.currentTimeMillis();
        mediumtime = System.currentTimeMillis();
        for (; ; ) {//The starting point of the game loop:
            ta.clear();//At the beginning of each iteration of the loop, we should clear the screen.
            //draw paddles , ball , line , background , power_ups:
            ta.drawSimpleRect(0, 0, 700, 500, background);//background color
            //Using saved time to draw first power_up and placing a random location for the power_up.
            if (System.currentTimeMillis() - show_time < 15000 && System.currentTimeMillis() - show_time > 14000) {
                power_draw = 2;
                food_x = random.nextInt(500) + 80;
                food_y = random.nextInt(400) + 50;
                show_time = System.currentTimeMillis();
            }
            if (power_draw == 2 && p1.getPaddle_height() == 80) {
                ta.drawSimpleCircle(food_x, food_y, 20, gold);
                ta.drawSimpleString("Increase", food_x - 30, food_y - 22, gold, 15);
            }
            //Using saved time to draw second power_up and placing a random location for it.
            if (System.currentTimeMillis() - show_time2 < 25000 && System.currentTimeMillis() - show_time2 > 14000) {
                power_draw2 = 2;
                food_x2 = random.nextInt(500) + 80;
                food_y2 = random.nextInt(400) + 50;
                show_time2 = System.currentTimeMillis();
            }
            if (power_draw2 == 2 && ball != background) {
                ta.drawSimpleCircle(food_x2, food_y2, 20, Color.white);
                ta.drawSimpleString("Hide Ball", food_x2 - 30, food_y2 - 22, Color.white, 15);
            }
            //........
            ta.drawSimpleLine(350, 0, 350, 500, Color.white);//Draw center line.
            ta.drawSimpleScore(b1.getLeft_Score(), b1.getRight_Score(), Color.yellow);//Draw score
            ta.drawSimpleCircle((int) b1.getBall_x(), (int) b1.getBall_y(), ball_radius, ball);//Draw ball
            //Draw paddles considering the conditions.
            if (ta.start() == 20 && side == 1) {
                ta.drawSimpleRect(paddle_x, p1.getPaddle_y1(), 20, p1.getPaddle_height(), paddleL);
                ta.drawSimpleRect(paddle_x2, pa.getPaddleA_y(), 20, p1.getPaddle_height(), paddleR);
            } else if (ta.start() == 20 && side == 2) {
                ta.drawSimpleRect(paddle_x, pa.getPaddleA_y(), 20, p1.getPaddle_height(), paddleL);
                ta.drawSimpleRect(paddle_x2, p2.getPaddle_y2(), 20, p1.getPaddle_height(), paddleR);
            }

            if (ta.start() == -20) {
                ta.drawSimpleRect(paddle_x, p1.getPaddle_y1(), 20, p1.getPaddle_height(), paddleL);
                ta.drawSimpleRect(paddle_x2, p2.getPaddle_y2(), 20, p1.getPaddle_height(), paddleR);
            }
            //end of draw.
            //Check game over:
            if (b1.getLeft_Score() == 5 || b1.getRight_Score() == 5) {//Game over condition.
                game_over = false;
            }
            if (!game_over) {
                sound.GameOver();
                break;
            }
            //end of check game over.
            //Check paddle collision:
            if (ta.start() == 20 && side == 1) {
                L_P_collision = p1.getPaddle_y1();
                R_P_collision = pa.getPaddleA_y();
            } else if (ta.start() == 20 && side == 2) {
                L_P_collision = pa.getPaddleA_y();
                R_P_collision = p2.getPaddle_y2();
            } else if (ta.start() == -20) {
                L_P_collision = p1.getPaddle_y1();
                R_P_collision = p2.getPaddle_y2();
            }
            b1.check_paddle_collision(L_P_collision, R_P_collision);
            //end of check paddle collision
            b1.move();//Move ball
            //Check power_up collision
            if (Math.abs(food_x - b1.getBall_x()) < 30 && p1.getPaddle_height() == 80) {//increase
                if (Math.abs(food_y - b1.getBall_y()) < 30 && power_draw == 2) {
//                    if(b1.getBall_x_Velocity()>0 && ta.start()==20 && side==1){
//                        p1.setPaddle_height(110);
//                    } else if (b1.getBall_x_Velocity()>0 && ta.start()==20 && side==2) {
//                        pa.p1.setPaddle_height(110);
//                    }else if(b1.getBall_x_Velocity()>0 && ta.start()== -20){
//                        p1.setPaddle_height(110);
//                    }else if(b1.getBall_x_Velocity()<0 && ta.start()==20 && side==1){
//                        pa.p1.setPaddle_height(110);
//                    } else if (b1.getBall_x_Velocity()<0 && ta.start()==20 && side==2) {
//                        p1.setPaddle_height(110);
//                    }else if(b1.getBall_x_Velocity()<0 && ta.start()== -20){
//                        p2.p1.setPaddle_height(110);
//                    }
                    p2.p1.setPaddle_height(110);
                    b1.p1.setPaddle_height(110);
                    pa.p1.setPaddle_height(110);
                    hide_time = System.currentTimeMillis();
                }
            }
            if (System.currentTimeMillis() - hide_time > 9000 && System.currentTimeMillis() - hide_time < 10000) {
                p1.setPaddle_height(80);
                p2.p1.setPaddle_height(80);
                pa.p1.setPaddle_height(80);
                b1.p1.setPaddle_height(80);
                power_draw = 0;
            }

            if (Math.abs(food_x2 - b1.getBall_x()) < 30 && ball != Color.black) {//Hide ball
                if (Math.abs(food_y2 - b1.getBall_y()) < 30 && power_draw2 == 2) {
                    HideBall = true;
                    ball = background;
                }
            }
            //end of check power_up collision
            //Check goal:
            if (b1.check_goal() == true) {
                p1.setPaddle_y1(210);
                p2.setPaddle_y2(210);
                if (BallSC == 1) {
                    ball = new Color(255, 255, 255);
                } else if (BallSC == 2) {
                    ball = new Color(0, 255, 0);
                } else if (BallSC == 3) {
                    ball = new Color(255, 0, 0);
                } else if (BallSC == 4) {
                    ball = new Color(0, 255, 255);
                } else if (BallSC == 5) {
                    ball = new Color(255, 255, 0);
                } else if (BallSC == 6) {
                    ball = new Color(255, 128, 0);
                }
                power_draw2 = 0;
                HideBall = false;
                Emove = 5;
                Mmove = 5;
            }//end of check goal
            //paddle1 move:
            if (ta.start() == 20 && side == 1) {
                p1.setPaddle_y_velocity1(ta.set_key());
                p1.move();
            } else if (ta.start() == -20) {
                p1.setPaddle_y_velocity1(ta.set_key());
                p1.move();
            }
            //paddle2 move:
            if (ta.start() == 20 && side == 2) {
                p2.setPaddle_y_velocity2(ta.set_key2());
                p2.move();
            } else if (ta.start() == -20) {
                p2.setPaddle_y_velocity2(ta.set_key2());
                p2.move();
            }
            //Paddle Ai move:
            if (System.currentTimeMillis() - easytime < 7000 && System.currentTimeMillis() - easytime > 6000) {
                easynum = random.nextInt(20);
                if (easynum <= 20 && easynum >= 13) {
                    Emove = 3;
                }
                easytime = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() - mediumtime < 12000 && System.currentTimeMillis() - mediumtime > 13000) {
                mediumnum = random.nextInt(20);
                if (mediumnum <= 20 && mediumnum >= 10) {
                    Mmove = 3;
                }
                mediumtime = System.currentTimeMillis();
            }
            if (b1.getBall_x_Velocity() > 8) {
                Emove = 3;
            }
            if (ta.start() == 20 && ta.level() == 2) {//medium
                pa.move(Mmove, ta.level());
            } else if (ta.start() == 20 && !HideBall && ta.level() == 1) {//easy
                pa.move(Emove, ta.level());
            } else if (ta.start() == 20 && ta.level() == 3) {//hard
                pa.move(0, ta.level());
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //Determining the winner of the game and the scores:
        ta.clear();
        ta.drawSimpleScore(b1.getLeft_Score(), b1.getRight_Score(), Color.cyan);
        ta.drawSimpleString("GAMEOVER", 260, 250, gold, 30);
        if (b1.getRight_Score() == 5) {
            ta.drawSimpleString("WINNER", 500, 200, Color.green, 30);
        } else if (b1.getLeft_Score() == 5) {
            ta.drawSimpleString("WINNER", 100, 200, Color.green, 30);
        }
    }
}