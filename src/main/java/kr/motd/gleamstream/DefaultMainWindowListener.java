package kr.motd.gleamstream;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_0;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_1;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_2;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_3;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_4;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_5;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_6;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_7;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_8;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_9;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_A;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_APOSTROPHE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_B;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_BACKSLASH;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_BACKSPACE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_C;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_CAPS_LOCK;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_COMMA;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_DELETE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_E;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_END;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ENTER;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_EQUAL;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F1;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F10;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F11;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F12;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F2;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F3;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F4;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F5;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F6;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F7;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F8;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_F9;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_G;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_GRAVE_ACCENT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_H;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_HOME;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_I;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_INSERT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_J;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_K;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_0;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_1;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_2;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_3;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_4;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_5;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_6;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_7;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_8;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_9;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_ADD;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_DECIMAL;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_DIVIDE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_ENTER;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_EQUAL;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_MULTIPLY;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_KP_SUBTRACT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_L;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LAST;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_ALT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_BRACKET;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_CONTROL;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_SHIFT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT_SUPER;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_M;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_MENU;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_MINUS;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_N;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_NUM_LOCK;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_O;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_P;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_PAGE_DOWN;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_PAGE_UP;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_PAUSE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_PERIOD;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_PRINT_SCREEN;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Q;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_R;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_ALT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_BRACKET;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_CONTROL;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_SHIFT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_SUPER;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_S;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_SCROLL_LOCK;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_SEMICOLON;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_SLASH;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_SPACE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_T;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_TAB;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_U;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_UP;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_V;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_W;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_WORLD_1;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_WORLD_2;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_X;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Y;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_Z;
import static org.lwjgl.glfw.GLFW.GLFW_MOD_ALT;
import static org.lwjgl.glfw.GLFW.GLFW_MOD_CONTROL;
import static org.lwjgl.glfw.GLFW.GLFW_MOD_SHIFT;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_MIDDLE;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_RIGHT;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_REPEAT;

import java.awt.event.KeyEvent;

import com.limelight.nvstream.NvConnection;
import com.limelight.nvstream.input.KeyboardPacket;
import com.limelight.nvstream.input.MouseButtonPacket;

final class DefaultMainWindowListener implements MainWindowListener {

    private static final short[] keyTable = new short[GLFW_KEY_LAST + 1];

    static {
        keyTable[GLFW_KEY_SPACE] = KeyEvent.VK_SPACE;
        keyTable[GLFW_KEY_APOSTROPHE] = 0xde;
        keyTable[GLFW_KEY_COMMA] = 0xbc;
        keyTable[GLFW_KEY_MINUS] = 0xbd;
        keyTable[GLFW_KEY_PERIOD] = 0xbe;
        keyTable[GLFW_KEY_SLASH] = 0xbf;
        keyTable[GLFW_KEY_0] = KeyEvent.VK_0;
        keyTable[GLFW_KEY_1] = KeyEvent.VK_1;
        keyTable[GLFW_KEY_2] = KeyEvent.VK_2;
        keyTable[GLFW_KEY_3] = KeyEvent.VK_3;
        keyTable[GLFW_KEY_4] = KeyEvent.VK_4;
        keyTable[GLFW_KEY_5] = KeyEvent.VK_5;
        keyTable[GLFW_KEY_6] = KeyEvent.VK_6;
        keyTable[GLFW_KEY_7] = KeyEvent.VK_7;
        keyTable[GLFW_KEY_8] = KeyEvent.VK_8;
        keyTable[GLFW_KEY_9] = KeyEvent.VK_9;
        keyTable[GLFW_KEY_SEMICOLON] = 0xba;
        keyTable[GLFW_KEY_EQUAL] = 0xbb;
        keyTable[GLFW_KEY_A] = KeyEvent.VK_A;
        keyTable[GLFW_KEY_B] = KeyEvent.VK_B;
        keyTable[GLFW_KEY_C] = KeyEvent.VK_C;
        keyTable[GLFW_KEY_D] = KeyEvent.VK_D;
        keyTable[GLFW_KEY_E] = KeyEvent.VK_E;
        keyTable[GLFW_KEY_F] = KeyEvent.VK_F;
        keyTable[GLFW_KEY_G] = KeyEvent.VK_G;
        keyTable[GLFW_KEY_H] = KeyEvent.VK_H;
        keyTable[GLFW_KEY_I] = KeyEvent.VK_I;
        keyTable[GLFW_KEY_J] = KeyEvent.VK_J;
        keyTable[GLFW_KEY_K] = KeyEvent.VK_K;
        keyTable[GLFW_KEY_L] = KeyEvent.VK_L;
        keyTable[GLFW_KEY_M] = KeyEvent.VK_M;
        keyTable[GLFW_KEY_N] = KeyEvent.VK_N;
        keyTable[GLFW_KEY_O] = KeyEvent.VK_O;
        keyTable[GLFW_KEY_P] = KeyEvent.VK_P;
        keyTable[GLFW_KEY_Q] = KeyEvent.VK_Q;
        keyTable[GLFW_KEY_R] = KeyEvent.VK_R;
        keyTable[GLFW_KEY_S] = KeyEvent.VK_S;
        keyTable[GLFW_KEY_T] = KeyEvent.VK_T;
        keyTable[GLFW_KEY_U] = KeyEvent.VK_U;
        keyTable[GLFW_KEY_V] = KeyEvent.VK_V;
        keyTable[GLFW_KEY_W] = KeyEvent.VK_W;
        keyTable[GLFW_KEY_X] = KeyEvent.VK_X;
        keyTable[GLFW_KEY_Y] = KeyEvent.VK_Y;
        keyTable[GLFW_KEY_Z] = KeyEvent.VK_Z;
        keyTable[GLFW_KEY_LEFT_BRACKET] = 0xdb;
        keyTable[GLFW_KEY_BACKSLASH] = 0xdc;
        keyTable[GLFW_KEY_RIGHT_BRACKET] = 0xdd;
        keyTable[GLFW_KEY_GRAVE_ACCENT] = KeyEvent.VK_BACK_QUOTE;
        keyTable[GLFW_KEY_WORLD_1] = 0;
        keyTable[GLFW_KEY_WORLD_2] = 0;
        keyTable[GLFW_KEY_ESCAPE] = KeyEvent.VK_ESCAPE;
        keyTable[GLFW_KEY_ENTER] = 0x0d;
        keyTable[GLFW_KEY_TAB] = KeyEvent.VK_TAB;
        keyTable[GLFW_KEY_BACKSPACE] = KeyEvent.VK_BACK_SPACE;
        keyTable[GLFW_KEY_INSERT] = KeyEvent.VK_INSERT;
        keyTable[GLFW_KEY_DELETE] = 0x2e;
        keyTable[GLFW_KEY_RIGHT] = KeyEvent.VK_RIGHT;
        keyTable[GLFW_KEY_LEFT] = KeyEvent.VK_LEFT;
        keyTable[GLFW_KEY_DOWN] = KeyEvent.VK_DOWN;
        keyTable[GLFW_KEY_UP] = KeyEvent.VK_UP;
        keyTable[GLFW_KEY_PAGE_UP] = KeyEvent.VK_PAGE_UP;
        keyTable[GLFW_KEY_PAGE_DOWN] = KeyEvent.VK_PAGE_DOWN;
        keyTable[GLFW_KEY_HOME] = KeyEvent.VK_HOME;
        keyTable[GLFW_KEY_END] = KeyEvent.VK_END;
        keyTable[GLFW_KEY_CAPS_LOCK] = KeyEvent.VK_CAPS_LOCK;
        keyTable[GLFW_KEY_SCROLL_LOCK] = KeyEvent.VK_SCROLL_LOCK;
        keyTable[GLFW_KEY_NUM_LOCK] = KeyEvent.VK_NUM_LOCK;
        keyTable[GLFW_KEY_PRINT_SCREEN] = KeyEvent.VK_PRINTSCREEN;
        keyTable[GLFW_KEY_PAUSE] = KeyEvent.VK_PAUSE;
        keyTable[GLFW_KEY_F1] = KeyEvent.VK_F1;
        keyTable[GLFW_KEY_F2] = KeyEvent.VK_F2;
        keyTable[GLFW_KEY_F3] = KeyEvent.VK_F3;
        keyTable[GLFW_KEY_F4] = KeyEvent.VK_F4;
        keyTable[GLFW_KEY_F5] = KeyEvent.VK_F5;
        keyTable[GLFW_KEY_F6] = KeyEvent.VK_F6;
        keyTable[GLFW_KEY_F7] = KeyEvent.VK_F7;
        keyTable[GLFW_KEY_F8] = KeyEvent.VK_F8;
        keyTable[GLFW_KEY_F9] = KeyEvent.VK_F9;
        keyTable[GLFW_KEY_F10] = KeyEvent.VK_F10;
        keyTable[GLFW_KEY_F11] = KeyEvent.VK_F11;
        keyTable[GLFW_KEY_F12] = KeyEvent.VK_F12;
        keyTable[GLFW_KEY_KP_0] = KeyEvent.VK_NUMPAD0;
        keyTable[GLFW_KEY_KP_1] = KeyEvent.VK_NUMPAD1;
        keyTable[GLFW_KEY_KP_2] = KeyEvent.VK_NUMPAD2;
        keyTable[GLFW_KEY_KP_3] = KeyEvent.VK_NUMPAD3;
        keyTable[GLFW_KEY_KP_4] = KeyEvent.VK_NUMPAD4;
        keyTable[GLFW_KEY_KP_5] = KeyEvent.VK_NUMPAD5;
        keyTable[GLFW_KEY_KP_6] = KeyEvent.VK_NUMPAD6;
        keyTable[GLFW_KEY_KP_7] = KeyEvent.VK_NUMPAD7;
        keyTable[GLFW_KEY_KP_8] = KeyEvent.VK_NUMPAD8;
        keyTable[GLFW_KEY_KP_9] = KeyEvent.VK_NUMPAD9;
        keyTable[GLFW_KEY_KP_DECIMAL] = KeyEvent.VK_DECIMAL;
        keyTable[GLFW_KEY_KP_DIVIDE] = KeyEvent.VK_DIVIDE;
        keyTable[GLFW_KEY_KP_MULTIPLY] = KeyEvent.VK_MULTIPLY;
        keyTable[GLFW_KEY_KP_SUBTRACT] = KeyEvent.VK_SUBTRACT;
        keyTable[GLFW_KEY_KP_ADD] = KeyEvent.VK_ADD;
        keyTable[GLFW_KEY_KP_ENTER] = keyTable[GLFW_KEY_ENTER];
        keyTable[GLFW_KEY_KP_EQUAL] = keyTable[GLFW_KEY_EQUAL];
        keyTable[GLFW_KEY_LEFT_SHIFT] = KeyEvent.VK_SHIFT;
        keyTable[GLFW_KEY_LEFT_CONTROL] = KeyEvent.VK_CONTROL;
        keyTable[GLFW_KEY_LEFT_ALT] = KeyEvent.VK_ALT;
        keyTable[GLFW_KEY_LEFT_SUPER] = KeyEvent.VK_WINDOWS;
        keyTable[GLFW_KEY_RIGHT_SHIFT] = KeyEvent.VK_SHIFT;
        keyTable[GLFW_KEY_RIGHT_CONTROL] = KeyEvent.VK_CONTROL;
        keyTable[GLFW_KEY_RIGHT_ALT] = KeyEvent.VK_ALT;
        keyTable[GLFW_KEY_RIGHT_SUPER] = KeyEvent.VK_WINDOWS;
        keyTable[GLFW_KEY_MENU] = KeyEvent.VK_CONTEXT_MENU;
    }

    private final NvConnection conn;
    private double lastXpos;
    private double lastYpos;

    DefaultMainWindowListener(NvConnection conn) {
        this.conn = conn;
    }

    @Override
    public void onKey(int key, int scancode, int action, int mods) {
        if (key < 0 || key >= keyTable.length) {
            return;
        }

        short nvKey = keyTable[key];
        if (nvKey == 0) {
            return;
        }

        nvKey = (short) (0x80 << 8 | nvKey);

        byte nvMods = 0x0;
        if ((mods & GLFW_MOD_SHIFT) != 0) {
            nvMods |= KeyboardPacket.MODIFIER_SHIFT;
        }
        if ((mods & GLFW_MOD_CONTROL) != 0) {
            nvMods |= KeyboardPacket.MODIFIER_CTRL;
        }
        if ((mods & GLFW_MOD_ALT) != 0) {
            nvMods |= KeyboardPacket.MODIFIER_ALT;
        }

        if (action == GLFW_PRESS || action == GLFW_REPEAT) {
            conn.sendKeyboardInput(nvKey, KeyboardPacket.KEY_DOWN, nvMods);
        } else {
            conn.sendKeyboardInput(nvKey, KeyboardPacket.KEY_UP, nvMods);
        }
    }

    @Override
    public void onCursorPos(double xpos, double ypos) {
        conn.sendMouseMove((short) (xpos - lastXpos), (short) (ypos - lastYpos));
        lastXpos = xpos;
        lastYpos = ypos;
    }

    @Override
    public void onMouseButton(int button, int action, int mods) {
        final byte nvButton;
        switch (button) {
            case GLFW_MOUSE_BUTTON_RIGHT:
                nvButton = MouseButtonPacket.BUTTON_RIGHT;
                break;
            case GLFW_MOUSE_BUTTON_MIDDLE:
                nvButton = MouseButtonPacket.BUTTON_MIDDLE;
                break;
            default:
                nvButton = MouseButtonPacket.BUTTON_LEFT;
        }
        if (action == GLFW_PRESS) {
            conn.sendMouseButtonDown(nvButton);
        } else {
            conn.sendMouseButtonUp(nvButton);
        }
    }

    @Override
    public void onScroll(double xoffset, double yoffset) {
        conn.sendMouseScroll((byte) -yoffset);
    }

    @Override
    public void onJoystick(int jid, int event) {}
}
