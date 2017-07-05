package com.google.api.services.samples.youtube.cmdline.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.api.services.youtube.model.PlaylistItem;


public class CreateUploadThumbnails {

	public static void main(String[] args) throws IOException
	{
		List<PlaylistItem> xyz=new ArrayList<PlaylistItem>();
		xyz= MyUploads.MyUploads();
		Iterator<PlaylistItem> playlistEntries=xyz.iterator();
		while (playlistEntries.hasNext()) {
            PlaylistItem playlistItem = playlistEntries.next();
            String title = playlistItem.getSnippet().getTitle();
            String ImageFile = PowerpointImage.CreateImage(title);
           UploadThumbnail.UploadThumbnails(playlistItem.getContentDetails().getVideoId(), ImageFile); 
                       
        }
	}
}
