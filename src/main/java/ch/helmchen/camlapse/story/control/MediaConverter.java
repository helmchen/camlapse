/*
 * File: MediaConverter.java, created at 02.01.2013
 * $Id$
 * Copyright 2013 Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.helmchen.camlapse.story.control;

import ch.helmchen.camlapse.story.entities.Storyboard;

import java.awt.image.BufferedImage;

import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;

import static com.xuggle.xuggler.Global.DEFAULT_TIME_UNIT;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @todo Klasse MediaConverter dokumentieren.
 * <p/>
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * @since 02.01.2013
 */
public class MediaConverter {
    public static void encodeVideo(Storyboard storyboard) {

// storyboard.
        // video parameters 
        final long duration = DEFAULT_TIME_UNIT.convert(5, SECONDS);
        final int videoStreamIndex = 0;
        final int videoStreamId = 0;
        final long frameRate = DEFAULT_TIME_UNIT.convert(15, MILLISECONDS);
        final int width = 320;
        final int height = 200;

        // audio parameters
//   final int audioStreamIndex = 1;
//   final int audioStreamId = 0;
//   final int channelCount = 1;
//   final int sampleRate = 44100; // Hz
//   final int sampleCount = 1000;

        // create a media writer and specify the output file
        final IMediaWriter writer = ToolFactory.makeWriter("myballs.mov");

        // add the video stream
        writer.addVideoStream(videoStreamIndex, videoStreamId, width, height);

        // add the audio stream 
//   writer.addAudioStream(audioStreamIndex, audioStreamId,
//      channelCount, sampleRate);

        // the clock time of the next frame
        long nextFrameTime = 0;

        // the total number of audio samples
        //long totalSampleCount = 0;

        // loop through clock time, which starts at zero and increases based
        // on the total number of samples created thus far

//   for (
//     long clock = 0;
//     clock < duration;
//     clock = IAudioSamples.samplesToDefaultPts(totalSampleCount, sampleRate)
//   )
        {
            // while the clock time exceeds the time of the next video frame,
            // get and encode the next video frame

            // while (clock >= nextFrameTime) {
            BufferedImage frame = null; //balls.getVideoFrame(frameRate);
            writer.encodeVideo(videoStreamIndex, frame, nextFrameTime,
                    DEFAULT_TIME_UNIT);
            nextFrameTime += frameRate;
        }

        // compute and encode the audio for the balls
//     short[] samples = balls.getAudioFrame(sampleRate);
//     writer.encodeAudio(audioStreamIndex, samples, clock, 
//       DEFAULT_TIME_UNIT);
//     totalSampleCount += sampleCount;
//   }

        // manually close the writer 
        writer.close();

    }

    /**
     * Convert a {@link BufferedImage} of any type, to {@link
     * BufferedImage} of a specified type. If the source image is the same type as the target type, then original image
     * is returned, otherwise new image of the correct type is created and the content of the source image is copied
     * into the new image.
     * <p/>
     * @param sourceImage the image to be converted
     * @param targetType  the desired BufferedImage type
     * <p/>
     * @return a BufferedImage of the specifed target type.
     * <p/>
     * @see BufferedImage
     */
    public static BufferedImage convertImage(BufferedImage sourceImage, int targetType) {
        BufferedImage image;
        // if the source image is already the target type, return the source image
        if (sourceImage.getType() == targetType) {
            image = sourceImage;
            // otherwise create a new image of the target type and draw the new
            // image 
        } else {
            image = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), targetType);
            image.getGraphics().drawImage(sourceImage, 0, 0, null);
        }
        return image;
    }
}
// EOF
