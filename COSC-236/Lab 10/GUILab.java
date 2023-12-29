import java.awt.*;
import java.util.*;

public class GUILab {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int choice;
        System.out.println("Select method 1 or method 2");
        while (!console.hasNextInt()) {
            System.out.println("Invalid choice, enter again: ");
            console.nextLine();
        }
        choice = console.nextInt();
        if (choice == 1) {
            drawShape();
        } else if (choice == 2) {
            drawSecondShape();
        } else {
            System.out.println("Out of range");
            System.exit(0);
        }

    }

    public static void drawShape() {
        DrawingPanel panel = new DrawingPanel(500, 500);
        Graphics g = panel.getGraphics();
        g.setColor(Color.CYAN);
        g.fillRect(150, 150, 200, 200);
        g.setColor(Color.BLACK);
        g.drawRect(150, 150, 200, 200);
        g.drawString("YOU WIN", 225, 250);
    }

    public static void drawSecondShape() {
        DrawingPanel panel = new DrawingPanel(500, 500);
        int[] xPoints = { 100, 400, 250 };
        int[] yPoints = { 250, 250, 100 };
        int nPoints = 3;
        Graphics g = panel.getGraphics();
        g.setColor(Color.RED);
        g.fillPolygon(xPoints, yPoints, nPoints);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, nPoints);
        g.drawString("GAME OVER", 215, 200);
    }
}
