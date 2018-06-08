import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.util.Log;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;

// Check if async task successfully retrieves a non-empty string array
@RunWith(AndroidJUnit4.class)
public class NonEmptyStringAsyncTask {

    private static final String LOG_TAG = NonEmptyStringAsyncTask.class.getSimpleName();

    @Test
    public void test() {
        Log.v("NonEmptyStringTest", "Running NonEmptyStringTest test");
        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(InstrumentationRegistry.getTargetContext());
        endpointsAsyncTask.execute();
        try {
            String[] stringArrayResult = endpointsAsyncTask.get();
            if (stringArrayResult != null) {
                result = endpointsAsyncTask.get()[1]; // Getting the 2nd element of the string array
            }
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNotNull(result);
    }

}
