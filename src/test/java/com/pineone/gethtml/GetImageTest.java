package com.pineone.gethtml;

import com.pineone.network.protocolaccess.getimage.GetImage;
import org.junit.Test;

/**
 * Created by Melvin on 2015. 12. 21..
 */
public class GetImageTest {

    GetImage getImage = new GetImage();

    @Test
    public void getImageFromWebTest() throws Exception {

        getImage.getImage("http://freestory.net/wp/wp-content/uploads/2015/03/docker012.png");

    }
}
