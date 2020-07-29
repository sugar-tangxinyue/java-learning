import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by mok on 2020/7/29.
 */
public class TrankFrame extends Frame {
    public TrankFrame() {
        setSize(800, 600);
        setResizable(false);
        setTitle("Tank war");
        setVisible(true);
        addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 被系统自动的调用
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        g.fillRect(200, 200, 50, 50);
    }
}
