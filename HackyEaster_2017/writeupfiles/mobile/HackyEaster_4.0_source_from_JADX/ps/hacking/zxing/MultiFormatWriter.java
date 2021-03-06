package ps.hacking.zxing;

import android.support.v4.app.NotificationCompat.WearableExtender;
import android.support.v4.view.MotionEventCompat;
import java.util.Map;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.protocol.HTTP;
import ps.hacking.hackyeaster.android.BuildConfig;
import ps.hacking.zxing.common.BitMatrix;
import ps.hacking.zxing.oned.CodaBarWriter;
import ps.hacking.zxing.oned.Code128Writer;
import ps.hacking.zxing.oned.Code39Writer;
import ps.hacking.zxing.oned.EAN13Writer;
import ps.hacking.zxing.oned.EAN8Writer;
import ps.hacking.zxing.oned.ITFWriter;
import ps.hacking.zxing.oned.UPCAWriter;
import ps.hacking.zxing.pdf417.encoder.PDF417Writer;
import ps.hacking.zxing.qrcode.QRCodeWriter;
import ps.hacking.zxing.qrcode.encoder.QRCode;

public final class MultiFormatWriter implements Writer {

    /* renamed from: ps.hacking.zxing.MultiFormatWriter.1 */
    static /* synthetic */ class C00871 {
        static final /* synthetic */ int[] $SwitchMap$ch$clx$zxing$BarcodeFormat;

        static {
            $SwitchMap$ch$clx$zxing$BarcodeFormat = new int[BarcodeFormat.values().length];
            try {
                $SwitchMap$ch$clx$zxing$BarcodeFormat[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$ch$clx$zxing$BarcodeFormat[BarcodeFormat.EAN_13.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$ch$clx$zxing$BarcodeFormat[BarcodeFormat.UPC_A.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$ch$clx$zxing$BarcodeFormat[BarcodeFormat.QR_CODE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$ch$clx$zxing$BarcodeFormat[BarcodeFormat.CODE_39.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$ch$clx$zxing$BarcodeFormat[BarcodeFormat.CODE_128.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$ch$clx$zxing$BarcodeFormat[BarcodeFormat.ITF.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$ch$clx$zxing$BarcodeFormat[BarcodeFormat.PDF_417.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$ch$clx$zxing$BarcodeFormat[BarcodeFormat.CODABAR.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public BitMatrix encode(String contents, BarcodeFormat format, int width, int height) throws WriterException {
        return encode(contents, format, width, height, null);
    }

    public BitMatrix encode(String contents, BarcodeFormat format, int width, int height, Map<EncodeHintType, ?> hints) throws WriterException {
        Writer writer;
        switch (C00871.$SwitchMap$ch$clx$zxing$BarcodeFormat[format.ordinal()]) {
            case WearableExtender.SIZE_XSMALL /*1*/:
                writer = new EAN8Writer();
                break;
            case ConnPerRouteBean.DEFAULT_MAX_CONNECTIONS_PER_ROUTE /*2*/:
                writer = new EAN13Writer();
                break;
            case WearableExtender.SIZE_MEDIUM /*3*/:
                writer = new UPCAWriter();
                break;
            case WearableExtender.SIZE_LARGE /*4*/:
                writer = new QRCodeWriter();
                break;
            case WearableExtender.SIZE_FULL_SCREEN /*5*/:
                writer = new Code39Writer();
                break;
            case MotionEventCompat.AXIS_TOOL_MAJOR /*6*/:
                writer = new Code128Writer();
                break;
            case BuildConfig.VERSION_CODE /*7*/:
                writer = new ITFWriter();
                break;
            case QRCode.NUM_MASK_PATTERNS /*8*/:
                writer = new PDF417Writer();
                break;
            case HTTP.HT /*9*/:
                writer = new CodaBarWriter();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + format);
        }
        return writer.encode(contents, format, width, height, hints);
    }
}
