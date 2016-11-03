package kr.motd.gleamstream;

import static kr.motd.gleamstream.Panic.panic;
import static org.lwjgl.glfw.GLFW.GLFW_BLUE_BITS;
import static org.lwjgl.glfw.GLFW.GLFW_CONTEXT_VERSION_MAJOR;
import static org.lwjgl.glfw.GLFW.GLFW_CONTEXT_VERSION_MINOR;
import static org.lwjgl.glfw.GLFW.GLFW_CURSOR;
import static org.lwjgl.glfw.GLFW.GLFW_CURSOR_DISABLED;
import static org.lwjgl.glfw.GLFW.GLFW_CURSOR_NORMAL;
import static org.lwjgl.glfw.GLFW.GLFW_DECORATED;
import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_GREEN_BITS;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_GRAVE_ACCENT;
import static org.lwjgl.glfw.GLFW.GLFW_MAXIMIZED;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_CORE_PROFILE;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_FORWARD_COMPAT;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_PROFILE;
import static org.lwjgl.glfw.GLFW.GLFW_RED_BITS;
import static org.lwjgl.glfw.GLFW.GLFW_REFRESH_RATE;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwGetFramebufferSize;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetCharCallback;
import static org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwSetInputMode;
import static org.lwjgl.glfw.GLFW.glfwSetJoystickCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback;
import static org.lwjgl.glfw.GLFW.glfwSetScrollCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.glfw.GLFWErrorCallback.getDescription;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_RGBA8;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_S;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_T;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDeleteTextures;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import static org.lwjgl.opengl.GL11.glTexSubImage2D;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.opengl.GL12.GL_BGRA;
import static org.lwjgl.opengl.GL12.GL_CLAMP_TO_EDGE;
import static org.lwjgl.opengl.GL30.GL_COLOR_ATTACHMENT0;
import static org.lwjgl.opengl.GL30.GL_READ_FRAMEBUFFER;
import static org.lwjgl.opengl.GL30.glBindFramebuffer;
import static org.lwjgl.opengl.GL30.glBlitFramebuffer;
import static org.lwjgl.opengl.GL30.glDeleteFramebuffers;
import static org.lwjgl.opengl.GL30.glFramebufferTexture2D;
import static org.lwjgl.opengl.GL30.glGenFramebuffers;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.IntBuffer;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;

import org.jctools.queues.MpscArrayQueue;
import org.jctools.queues.SpscArrayQueue;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.Platform;

import kr.motd.gleamstream.FFmpegFramePool.FFmpegFrame;

public class MainWindow {

    public static final MainWindow INSTANCE = new MainWindow();

    private final CompletableFuture<?> startFuture = new CompletableFuture<>();
    private final Queue<FFmpegFrame> pendingFrames = new SpscArrayQueue<>(64);
    private final Queue<Runnable> pendingTasks = new MpscArrayQueue<>(64);

    private long window;
    private NuklearHelper nk;
    private int frameTexture;
    private int frameBuffer;
    private boolean receivedFirstFrame;
    private FFmpegFrame lastFrame;

    private long lastGravePressTime = System.nanoTime();
    private boolean showOsd;

    private long lastFpsCheckTime = System.nanoTime();
    private int droppedFrameCounter;
    private int frameCounter;
    private long renderTimeCounter;

    private volatile MainWindowListener listener;

    private MainWindow() {}

    public void addFrame(FFmpegFrame frame) {
        pendingFrames.add(frame);
    }

    public void setListener(MainWindowListener listener) {
        this.listener = listener;
    }

    public CompletableFuture<?> start() {
        Thread thread = new Thread(this::run);
        thread.setName("Main Window");
        thread.start();

        return startFuture;
    }

    public void destroy() {
        pendingTasks.add(() -> glfwSetWindowShouldClose(window, true));
    }

    private void run() {
        try {
            init();
            startFuture.complete(null);
            loop();
        } finally {
            releaseLastFrame();

            if (nk != null) {
                nk.destroy();
            }

            if (frameBuffer != 0) {
                glDeleteFramebuffers(frameBuffer);
            }
            if (frameTexture != 0) {
                glDeleteTextures(frameTexture);
            }

            glfwTerminate();
            glfwSetErrorCallback(null).free();
        }

        System.exit(0);
    }

    private void init() {
        GLFWErrorCallback.create(MainWindow::onError).set();

        if (!glfwInit()) {
            throw panic("Unable to initialize GLFW");
        }

        final long primaryMonitor = glfwGetPrimaryMonitor();
        if (primaryMonitor == NULL) {
            throw panic("Failed to get the primary monitor");
        }

        final GLFWVidMode videoMode = glfwGetVideoMode(primaryMonitor);
        if (videoMode == null) {
            throw panic("Failed to get the current video mode");
        }

        // Create a borderless full screen window.
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_DECORATED, GLFW_FALSE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);
        glfwWindowHint(GLFW_RED_BITS, videoMode.redBits());
        glfwWindowHint(GLFW_GREEN_BITS, videoMode.greenBits());
        glfwWindowHint(GLFW_BLUE_BITS, videoMode.blueBits());
        glfwWindowHint(GLFW_REFRESH_RATE, videoMode.refreshRate());
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        if (Platform.get() == Platform.MACOSX) {
            glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);
        }

        final int width = videoMode.width();
        final int height = videoMode.height();
        window = glfwCreateWindow(width, height, "GleamStream", NULL, NULL);
        if (window == NULL) {
            throw panic("Failed to create the main window");
        }

        glfwMakeContextCurrent(window);
        glfwSetWindowPos(window, 0, 0);
        glfwSwapInterval(1);
        glfwSetKeyCallback(window, this::onKey);
        glfwSetCharCallback(window, this::onChar);
        glfwSetJoystickCallback(this::onJoystick);
        glfwSetScrollCallback(window, this::onScroll);
        glfwSetCursorPosCallback(window, this::onCursorPos);
        glfwSetMouseButtonCallback(window, this::onMouseButton);

        GL.createCapabilities();
        glEnable(GL_TEXTURE_2D);
        glDisable(GL_DEPTH_TEST);
        glDisable(GL_LIGHTING);
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        // Initialize Nuklear.
        nk = new NuklearHelper(window);
        nk.init();

        // Initialize the texture and the frame buffer for displaying the video stream.
        frameTexture = glGenTextures();
        frameBuffer = glGenFramebuffers();
        glBindTexture(GL_TEXTURE_2D, frameTexture);
        glBindFramebuffer(GL_READ_FRAMEBUFFER, frameBuffer);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, 2048, 2048, 0, GL_BGRA, GL_UNSIGNED_BYTE, NULL);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
        glFramebufferTexture2D(GL_READ_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_TEXTURE_2D, frameTexture, 0);
        glBindFramebuffer(GL_READ_FRAMEBUFFER, 0);
        glBindTexture(GL_TEXTURE_2D, 0);

        // Show the main window.
        glfwShowWindow(window);
    }

    private void loop() {
        while (!glfwWindowShouldClose(window)) {
            // Get the width and height of the frame buffer.
            int width;
            int height;
            try (MemoryStack stack = stackPush()) {
                IntBuffer widthBuf = stack.mallocInt(1);
                IntBuffer heightBuf = stack.mallocInt(1);

                glfwGetFramebufferSize(window, widthBuf, heightBuf);
                width = widthBuf.get(0);
                height = heightBuf.get(0);
            }

            // Set the viewport and clear.
            glViewport(0, 0, width, height);
            glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            handlePendingFrames(width, height);
            handlePendingTasks();

            if (showOsd || !receivedFirstFrame) {
                glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_NORMAL);
                nk.prepare();
                Osd.INSTANCE.layout(nk, width, height);
                nk.render();
            } else {
                glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_DISABLED);
                glfwSetKeyCallback(window, this::onKey);
                glfwPollEvents();
            }
            glfwSwapBuffers(window); // swap the color buffers
        }
    }

    private void handlePendingFrames(int width, int height) {
        final int numFrames = pendingFrames.size();
        if (numFrames == 0) {
            if (lastFrame != null) {
                drawFrame(width, height, lastFrame);
            }
            return;
        }

        if (numFrames > 2) {
            for (int i = 1; i < numFrames; i++) {
                pendingFrames.poll().release();
                droppedFrameCounter++;
            }
        }

        final FFmpegFrame e = pendingFrames.poll();
        releaseLastFrame();

        receivedFirstFrame = true;
        drawFrame(width, height, e);

        lastFrame = e;
    }

    private void releaseLastFrame() {
        if (lastFrame != null) {
            lastFrame.release();
            lastFrame = null;
        }
    }

    private void drawFrame(int fbWidth, int fbHeight, FFmpegFrame e) {
        final long renderStartTime = System.nanoTime();
        final int sourceWidth = e.width();
        final int sourceHeight = e.height();
        final int zoomedX;
        final int zoomedY;
        final int zoomedWidth;
        final int zoomedHeight;
        if (sourceHeight * fbWidth > fbHeight * sourceWidth) {
            zoomedWidth = sourceWidth * fbHeight / sourceHeight;
            zoomedHeight = fbHeight;
        } else {
            zoomedWidth = fbWidth;
            zoomedHeight = sourceHeight * fbWidth / sourceWidth;
        }
        zoomedX = fbWidth - zoomedWidth >>> 1;
        zoomedY = fbHeight - zoomedHeight >>> 1;

        glBindTexture(GL_TEXTURE_2D, frameTexture);
        glBindFramebuffer(GL_READ_FRAMEBUFFER, frameBuffer);

        glTexSubImage2D(GL_TEXTURE_2D, 0, 0, 0, sourceWidth, sourceHeight,
                        GL_BGRA, GL_UNSIGNED_BYTE, e.dataAddress());
        glBlitFramebuffer(0, sourceHeight, sourceWidth, 0,
                          zoomedX, zoomedY,
                          zoomedWidth + zoomedX, zoomedHeight + zoomedY, GL_COLOR_BUFFER_BIT, GL_NEAREST);
        glBindFramebuffer(GL_READ_FRAMEBUFFER, 0);
        glBindTexture(GL_TEXTURE_2D, 0);

        final long currentTime = System.nanoTime();
        final long elapsedTime = currentTime - lastFpsCheckTime;

        frameCounter++;
        renderTimeCounter += currentTime - renderStartTime;
        final long interval = 1000000000L; // 1 second
        if (elapsedTime > interval) {
            Osd.INSTANCE.setStatus(String.format(
                    "fps: %2.2f, drops/s: %2.2f, ms/f: %2.2f",
                    frameCounter * 1000000000.0 / elapsedTime,
                    droppedFrameCounter * 1000000000.0 / elapsedTime,
                    renderTimeCounter / 1000000.0 / frameCounter));
            frameCounter = 0;
            droppedFrameCounter = 0;
            renderTimeCounter = 0;
            lastFpsCheckTime = currentTime;
        }
    }

    private void handlePendingTasks() {
        for (;;) {
            final Runnable task = pendingTasks.poll();
            if (task == null) {
                break;
            }
            task.run();
        }
    }

    private void onKey(long window, int key, int scancode, int action, int mods) {
        if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE && showOsd) {
            glfwSetWindowShouldClose(window, true);
            return;
        }

        if (key == GLFW_KEY_GRAVE_ACCENT && action == GLFW_RELEASE) {
            // Toggle the OSD if the grave (backquote) key was pressed twice within one second.
            final long currentTime = System.nanoTime();
            if (currentTime - lastGravePressTime < 1000000000L) {
                showOsd = !showOsd;
                return;
            }
            lastGravePressTime = currentTime;
        }

        if (showOsd) {
            nk.onKey(window, key, scancode, action, mods);
        } else if (listener != null) {
            listener.onKey(key, scancode, action, mods);
        }
    }

    private void onChar(long window, int codepoint) {
        if (showOsd) {
            nk.onChar(window, codepoint);
        }
    }

    private void onCursorPos(long window, double xpos, double ypos) {
        if (showOsd) {
            nk.onCursorPos(window, xpos, ypos);
        } else if (listener != null) {
            listener.onCursorPos(xpos, ypos);
        }
    }

    private void onMouseButton(long window, int button, int action, int mods) {
        if (showOsd) {
            nk.onMouseButton(window, button, action, mods);
        } else if (listener != null) {
            listener.onMouseButton(button, action, mods);
        }
    }

    private void onScroll(long window, double xoffset, double yoffset) {
        if (showOsd) {
            nk.onScroll(window, xoffset, yoffset);
        } else if (listener != null) {
            listener.onScroll(xoffset, yoffset);
        }
    }

    private void onJoystick(int jid, int event) {
        if (listener != null) {
            listener.onJoystick(jid, event);
        }
    }

    private static void onError(int error, long description) {
        throw panic(String.format("[0x%X]: %s", error, getDescription(description)));
    }
}
