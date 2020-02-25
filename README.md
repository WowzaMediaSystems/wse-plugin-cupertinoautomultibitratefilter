# CupertinoAutoMultibitrateFilter
The **ModuleCupertinoAutoMultibitrateFilter** module for [Wowza Streaming Engine™ media server software](https://www.wowza.com/products/streaming-engine) enables you to create an audio-only rendition of the stream for delivery to Apple iOS devices.

This repo includes a [compiled version](/lib/wse-plugin-cupertinoautomultibitratefilter.jar).

## Prerequisites
Wowza Streaming Engine 4.2 or later is required.

## Usage
When you configure a live application in Wowza Streaming Engine to create streams that are compliant with the Apple App Store, one of the requirements is to create an audio-only rendition of the stream for delivery to Apple iOS devices. A special multi-bitrate playlist is created that includes an audio-only rendition but this playlist may cause playback problems with other players that support Apple HLS playback. Use this module to filter player connections based on a player's User-Agent string in order to turn off the audio-only stream for players that have trouble playing the stream correctly.


## More resources
To use the compiled version of this module, see [Filter audio-only rendition in Apple HLS auto-generated multi-bitrate playlist with a Wowza Streaming Engine Java module](https://www.wowza.com/docs/how-to-filter-audio-only-rendition-in-apple-hls-auto-generated-multi-bitrate-playlist-modulecupertinoautomultibitratefilter).

[Wowza Streaming Engine Server-Side API Reference](https://www.wowza.com/resources/serverapi/)

[How to extend Wowza Streaming Engine using the Wowza IDE](https://www.wowza.com/docs/how-to-extend-wowza-streaming-engine-using-the-wowza-ide)

Wowza Media Systems™ provides developers with a platform to create streaming applications and solutions. See [Wowza Developer Tools](https://www.wowza.com/developer) to learn more about our APIs and SDK.

## Contact
[Wowza Media Systems, LLC](https://www.wowza.com/contact)

## License
This code is distributed under the [Wowza Public License](https://github.com/WowzaMediaSystems/wse-plugin-cupertinoautomultibitratefilter/blob/master/LICENSE.txt).
