# Recommended Venue Finder

A very simple microservice to find recommended venues for a location using the 
[FourSquare](https://developer.foursquare.com/docs/api/getting-started) api

## Running
### Prerequisite

You’ll need to sign up as a Foursquare developer and create an app in order to use their services.

Once you've done that you'll have a `Client Id` & `Client Secret` to use with this microservice

### Steps

* Check out this repository from GitHub
* `cd` to the `Whitbread` directory - the following commands assume you are in the `Whitbread` directory
* export your `Client Id` & `Client Secret` so the `Venue Finder` can use them:
```bash
export client_id=<your client id>
export client_secret=<your client secret>

```
* Run the `Venue Finder`:
```bash
./gradlew bootRun

```
In your browser, navigate to http://localhost:8080/venue?name=Redhill and you should see the JSON containing recommended venues

You can substitute the place name of your choice

The JSON output is simply the same as that produced by FourSquare, see https://developer.foursquare.com/docs/api/venues/explore for details
