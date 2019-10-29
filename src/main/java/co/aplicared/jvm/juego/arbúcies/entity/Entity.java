package co.aplicared.jvm.juego.arbúcies.entity;

import co.aplicared.jvm.juego.arbúcies.graphics.Screen;
import co.aplicared.jvm.juego.arbúcies.level.Level;

import java.util.Random;

public abstract class Entity {
    protected final Random random = new Random();
    public int x, y;
    protected Level level;
    private boolean _isRemoved = false;

    public void update() {
    }

    public void render(Screen screen) {
    }

    public void remove() {
        _isRemoved = true;
    }

    public boolean isRemoved() {
        return _isRemoved;
    }
}
