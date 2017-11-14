### Meetup: Machine Learning - Hands on Code

#### Environment Configuration (Python 3.6):
- Download and install [Anaconda](https://www.anaconda.com/download/). Make sure it is registered in your PATH environment variable.
- Update Anaconda packages:
    `conda update --all`
- Create an Anaconda environment:
    `conda create -n meetup python=3.6 jupyter scikit-learn scikit-image`
- Activate the environment:
    `source activate meetup`
- Update setuptools: `pip install --upgrade -I setuptools`
- Find the right tfBinaryURL for you [in this url](https://www.tensorflow.org/install/install_mac#the_url_of_the_tensorflow_python_package) and run: `sudo pip  install --upgrade tfBinaryURL`

#### Data:
- Download the train and test files from the [Dogs vs. Cats problem in Kaggle](https://www.kaggle.com/c/dogs-vs-cats/data)