package at.csae0.reactnative.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;

import at.csae0.reactnative.R;
import at.csae0.reactnative.utils.CONFIG_TYPE;
import at.csae0.reactnative.utils.TOOL_TYPE;

public class GeneralConfig extends Config {

    private String backgroundImagePath, imageSaveName, fontFamily, initialText;
    private TOOL_TYPE initialToolSelection;

    public GeneralConfig (@Nullable String backgroundImagePath, @Nullable String imageSaveName, @Nullable String fontFamily, @Nullable String initialToolSelection, @Nullable String initialText) {
        super(CONFIG_TYPE.GENERAL_CONFIG, true);

        setBackgroundImagePath(backgroundImagePath);
        setImageSaveName(imageSaveName);
        setFontFamily(fontFamily);
        setInitialToolSelection(initialToolSelection);
        setInitialText(initialText);
    }

    @Nullable
    public String getBackgroundImagePath() {
        return backgroundImagePath;
    }

    @Nullable
    public Drawable getBackgroundDrawable(Context context, @Nullable BitmapFactory.Options options) {
        Bitmap bitmap = BitmapFactory.decodeFile(backgroundImagePath, options);
        if (bitmap != null) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
        return null;
    }

    @Nullable
    public String getImageSaveName() {
        return imageSaveName;
    }
    @Nullable
    public String getFontFamily() {
        return fontFamily;
    }
    @Nullable
    public TOOL_TYPE getInitialToolSelection() {
        return initialToolSelection;
    }
    @Nullable
    public String getInitialText() {
            return initialText;
    }

    public void setBackgroundImagePath(@Nullable String backgroundImagePath) {
        this.backgroundImagePath = backgroundImagePath;
    }

    public void setImageSaveName(@Nullable String imageSaveName) {
        this.imageSaveName = imageSaveName;
    }

    public void setFontFamily(@Nullable String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public void setInitialToolSelection(@Nullable TOOL_TYPE initialToolSelection) {
        this.initialToolSelection = initialToolSelection;
    }
    public void setInitialToolSelection(@Nullable String initialToolSelection) {
        this.initialToolSelection = TOOL_TYPE.get(initialToolSelection);
    }
    public void setInitialText(@Nullable String initialText) {
        this.initialText = initialText;
    }


    public boolean hasBackgroundImagePath() {
        return backgroundImagePath != null;
    }
    public boolean hasBackgroundDrawable() {
        if (hasBackgroundImagePath()) {
            return BitmapFactory.decodeFile(backgroundImagePath) != null;
        }
        return false;
    }

    public boolean hasImageSaveName() {
        return imageSaveName != null;
    }
    public boolean hasFontFamily() {
        return fontFamily != null;
    }
    public boolean hasInitialToolSelection() {
        return initialToolSelection != null;
    }
    public boolean hasInitialText() {
        return initialText != null;
    }
}
