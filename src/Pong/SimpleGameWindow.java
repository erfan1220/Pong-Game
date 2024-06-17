package Pong;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;
public class SimpleGameWindow {
    private SoundEffect sound;
    private JFrame frame;
    private JPanel panel;
    private Image image;
    private int width;
    private int height;
    public Queue<Character> keyQueue;
    boolean UpAccel, DownAccel, UpAccel2, DownAccel2, press_a, press_b, press1, press2;
    boolean press3, press4, press5, press11, press22, press33, press44, press55, press66,exit;
    boolean press6, press111, press222, press333, press444, press555, press666, PL, PR;
    boolean press1_b, press2_b, press3_b,Hard,Easy,Medium,gamestart;
    int t1 = 0;

    public void SimpleGameWindow1(int width, int height, String title) {
        this.height = height;
        this.width = width;
        sound = new SoundEffect();
        keyQueue = new LinkedList<>();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        frame = new JFrame(title);
        panel = new JPanel(true) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null); //TODO: Attend null observer later
                g.setColor(Color.cyan);
                g.fillRect(0, 0, 700, 5);
                g.setColor(Color.cyan);
                g.fillRect(0, 458, 700, 5);
            }
        };

        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        panel.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setFocusable(false);
        panel.setFocusable(true);
        panel.requestFocus();
        KeyListener keyListener = new KeyListener() {

            @Override
            public void keyPressed(KeyEvent ke) {
                //Key listener for paddle movement
                if (ke.getKeyCode() == KeyEvent.VK_W) {
                    UpAccel = true;
                } else if (ke.getKeyCode() == KeyEvent.VK_S) {
                    DownAccel = true;
                }else if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                    gamestart = true;
                }

                if (ke.getKeyCode() == KeyEvent.VK_UP) {
                    UpAccel2 = true;
                } else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                    DownAccel2 = true;
                }
                //Key listener for color of the background
                if (ke.getKeyCode() == KeyEvent.VK_1 && t1 == 6) {
                    sound.KeySound();
                    press1_b = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_2 && t1 == 6) {
                    sound.KeySound();
                    press2_b = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_3 && t1 == 6) {
                    sound.KeySound();
                    press3_b = true;
                    t1++;
                }
                //Key listener for color of the right paddle.
                if (ke.getKeyCode() == KeyEvent.VK_1 && t1 == 5) {
                    sound.KeySound();
                    press111 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_2 && t1 == 5) {
                    sound.KeySound();
                    press222 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_3 && t1 == 5) {
                    sound.KeySound();
                    press333 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_4 && t1 == 5) {
                    sound.KeySound();
                    press444 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_5 && t1 == 5) {
                    sound.KeySound();
                    press555 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_6 && t1 == 5) {
                    sound.KeySound();
                    press666 = true;
                    t1++;
                }
                //Key listener for color of the ball.
                if (ke.getKeyCode() == KeyEvent.VK_1 && t1 == 4) {
                    sound.KeySound();
                    press11 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_2 && t1 == 4) {
                    sound.KeySound();
                    press22 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_3 && t1 == 4) {
                    sound.KeySound();
                    press33 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_4 && t1 == 4) {
                    sound.KeySound();
                    press44 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_5 && t1 == 4) {
                    sound.KeySound();
                    press55 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_6 && t1 == 4) {
                    sound.KeySound();
                    press66 = true;
                    t1++;
                }
                //Key listener for color of the left paddle.
                if (ke.getKeyCode() == KeyEvent.VK_1 && t1 == 3) {
                    sound.KeySound();
                    press1 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_2 && t1 == 3) {
                    sound.KeySound();
                    press2 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_3 && t1 == 3) {
                    sound.KeySound();
                    press3 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_4 && t1 == 3) {
                    sound.KeySound();
                    press4 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_5 && t1 == 3) {
                    sound.KeySound();
                    press5 = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_6 && t1 == 3) {
                    sound.KeySound();
                    press6 = true;
                    t1++;
                }
                //Key listener for level
                if(ke.getKeyCode() == KeyEvent.VK_3 && t1==2){
                    sound.KeySound();
                    Hard = true;
                    t1++;
                }else if(ke.getKeyCode() == KeyEvent.VK_1 && t1==2){
                    sound.KeySound();
                    Easy = true;
                    t1++;
                }else if(ke.getKeyCode() == KeyEvent.VK_2 && t1==2){
                    sound.KeySound();
                    Medium = true;
                    t1++;
                }
                //Key listener for side
                if (ke.getKeyCode() == KeyEvent.VK_1 && t1==1) {
                    sound.KeySound();
                    PL = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_2 && t1==1) {
                    sound.KeySound();
                    PR = true;
                    t1++;
                }
                //Key listener for main menu.
                if (ke.getKeyCode() == KeyEvent.VK_1 && t1 == 0) {
                    sound.KeySound();
                    press_a = true;
                    t1++;
                } else if (ke.getKeyCode() == KeyEvent.VK_2 && t1 == 0) {
                    sound.KeySound();
                    press_b = true;
                    t1+=3;
                }else if(ke.getKeyCode() == KeyEvent.VK_3 && t1==0){
                    sound.KeySound();
                    exit=true;
                    t1++;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    UpAccel = false;
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    DownAccel = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    UpAccel2 = false;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    DownAccel2 = false;
                }

            }

            @Override
            public void keyTyped(KeyEvent ke) {
                keyQueue.add(ke.getKeyChar());
            }
        };

        panel.addKeyListener(keyListener);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    public void drawSimpleCircle(int x, int y, int r, Color colour) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Graphics2D g2d = (Graphics2D) image.getGraphics();
                g2d.setColor(colour);
                g2d.fillOval(x - r, y - r, r, r);
                panel.repaint();
            }
        });
    }

    public void drawSimpleRect(int x, int y, int width, int height, Color colour) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Graphics2D g2d = (Graphics2D) image.getGraphics();
                g2d.setColor(colour);
                g2d.fill3DRect(x, y, width, height, true);
                panel.repaint();
            }
        });
    }

    public void drawSimpleScore(int x, int y, Color colour) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Graphics2D g2d = (Graphics2D) image.getGraphics();
                g2d.setColor(colour);
                Font f1 = new Font("GO", Font.PLAIN, 20);
                g2d.setFont(f1);
                g2d.drawString(String.valueOf(x), 100, 100);
                g2d.drawString(String.valueOf(y), 600, 100);
                panel.repaint();
            }
        });
    }

    public void drawSimpleString(String str, int x, int y, Color colour, int size) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Graphics2D g2d = (Graphics2D) image.getGraphics();
                g2d.setColor(colour);
                Font f1 = new Font("GO", Font.PLAIN, size);
                g2d.setFont(f1);
                g2d.drawString(str, x, y);
                panel.repaint();
            }
        });
    }

    public void drawSimpleLine(int x1, int y1, int x2, int y2, Color color) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Graphics2D g2d = (Graphics2D) image.getGraphics();
                g2d.setColor(color);
                g2d.drawLine(x1, y1, x2, y2);
                panel.repaint();
            }
        });
    }

    public void clear() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Graphics2D g2d = (Graphics2D) image.getGraphics();
                g2d.clearRect(0, 0, width, height);
                panel.repaint();
            }
        });
    }

    public Character getKey() {
        if (!keyQueue.isEmpty()) {
            return keyQueue.poll();
        }
        return null;
    }

    public int set_key() {
        if (UpAccel == true) {
            return -5;
        } else if (DownAccel == true) {
            return 5;
        }
        return 0;
    }

    public int set_key2() {
        if (UpAccel2 == true) {
            return -5;
        } else if (DownAccel2 == true) {
            return 5;
        }
        return 0;
    }

    public int start() {
        if (press_a == true) {
            return 20;
        } else if (press_b == true) {
            return -20;
        }else if(exit==true){
            System.exit(0);
        }
        return 0;
    }

    public int set_color() {
        if (press1 == true) {
            return 1;
        } else if (press2 == true) {
            return 2;
        } else if (press3 == true) {
            return 3;
        } else if (press4 == true) {
            return 4;
        } else if (press5 == true) {
            return 5;
        } else if (press6 == true) {
            return 6;
        }
        return 0;
    }

    public int set_color2() {
        if (press11 == true) {
            return 1;
        } else if (press22 == true) {
            return 2;
        } else if (press33 == true) {
            return 3;
        } else if (press44 == true) {
            return 4;
        } else if (press55 == true) {
            return 5;
        } else if (press66 == true) {
            return 6;
        }
        return 0;
    }

    public int set_color3() {
        if (press111 == true) {
            return 1;
        } else if (press222 == true) {
            return 2;
        } else if (press333 == true) {
            return 3;
        } else if (press444 == true) {
            return 4;
        } else if (press555 == true) {
            return 5;
        } else if (press666 == true) {
            return 6;
        }
        return 0;
    }

    public int set_background_color() {
        if (press1_b == true) {
            return 1;
        } else if (press2_b == true) {
            return 2;
        } else if (press3_b == true) {
            return 3;
        }
        return 0;
    }

    public int set_place() {
        if (PL == true) {
            return 1;
        } else if (PR == true) {
            return 2;
        }
        return 0;
    }
    public int level(){
        if (Hard == true) {
            return 3;
        } else if (Easy == true) {
            return 1;
        }else if(Medium == true){
            return 2;
        }
        return 0;
    }
    public int gamestart(){
        if(gamestart == true){
            return 1;
        }
        return 0;
    }

}
