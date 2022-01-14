
## Testing containerised version app
* Copy the folder ``app`` on your host machine(Use the folder as it is.Donot delete any files.)
* Run the following commands for building image and starting the application.

### Build Docker Container
``` 
$ docker build -t test:t .
```

### Start application with Docker
```
$ docker run -it --rm test:t
```
* As a host, VM(Ubuntu 18.04 LTS (Bionic) Server Version) is used to test the above java application.

## Test with ``Eclipse  IDE  2019-09``
* Copy ``test.zip`` in your desired location
* Start ``Eclipse  IDE  2019-09``
* Click: File→Import...→General→Existing Projects into Workspace→Select archive file:→Browse... Select the ``test.zip`` file you copyed before.
* Click: ``Finish``
* Run the application.
