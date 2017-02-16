# Tech Meetup: Deep Learning and TensorFlow

![Cats vs Dogs](woof_meow.jpg?raw=true "Cats vs Dogs")

## Cats vs Dogs Data set:
Download the data set directly from [Kaggle](https://www.kaggle.com/c/dogs-vs-cats)

## Environment setup:
### 1 Download & install anaconda:
* Download [here](https://www.continuum.io/downloads) the latest anaconda version for Linux or Mac (Python 3.5)
* Run: bash ~/path_to_download/Anaconda_downloaded_version.sh
* On installation accept to add Anaconda directory to your bash shell PATH environment variable.
* Update conda packages, run: conda update --all

### 2 Download & install tensorflow:
* Create anaconda environment for tensorflow, run:
  conda create -n tf python=3.5 jupyter scikit-learn scikit-image
* Enter the environment:
  source activate tf
* Download tensorflow:
  [cpu only version](https://storage.googleapis.com/tensorflow/linux/cpu/tensorflow-0.9.0rc0-cp35-cp35m-linux_x86_64.whl)
  [gpu enabled version](https://storage.googleapis.com/tensorflow/linux/gpu/tensorflow-0.9.0rc0-cp35-cp35m-linux_x86_64.whl). 
  Check last version [here](https://www.tensorflow.org)
* Upgrade setuptools:
  pip install --upgrade -I setuptools
* Install tensorflow:
  pip install --upgrade tensorflow_path
* Install tflearn:
  pip install tflearn

#####Follow me on twitter:
[@unindanachado](https://twitter.com/unindanachado)

