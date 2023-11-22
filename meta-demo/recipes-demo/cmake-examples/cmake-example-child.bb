# Recipes should always have a SUMMARY and sometimes a DESCRIPTION.
SUMMARY = "The cmake-examples project from the previous demo on CMake"

# Recipes always have a version number. It can either be placed in the
# filename (cmake-example-child_1.0.0.bb) or by explicitly specifying the PV
# variable. When fetching a Git repository, you can use ${SRCPV} to get the
# commit hash (even/especially if ${AUTOREV} is used; see below).
PV = "1.0.0"

# Every recipe must specify its license. There is also a QA license-checking
# mechanism to catch cases where the source package's license changes, and to
# generate a manifest of the licenses used for an image.
LICENSE = "CLOSED"

# It's rare (but possible) to write a recipe completely from scratch. Usually
# we rely on a base class to do most of the boilerplate work. There are a
# large number of community-supported base classes for all common package
# types such as CMake, autotools, etc. In this case we have a CMake project.
inherit cmake

# Every recipe consumes zero or more sources specified by SRC_URI. The
# sources, the recipe itself, and the environment state (the values of all
# variables) collectively generate a recipe's signature. The signature is used
# to determine what may have changed, and based on the dependency tree, what
# needs to be rebuilt.
SRC_URI = "git://github.com/dvnrrs/cmake-examples;protocol=https;branch=main"

# In this case, we're using the 'git' fetcher. We have already told it, via
# fetch options, which protocol to use (https) and which branch to get (main).
# Now we need to tell it which specific revision within the fetched branch to
# use. You can use "${AUTOREV}" to get the latest commit, but this results in
# non-reproducible builds and is strongly discouraged!
SRCREV = "7ea96ced8d5bbe879bca21b9794574d13722126f"

# The 'S' variable is a key variable specifying the root source directory. The
# 'git' fetcher clones the repository in a 'git' subdirectory underneath the
# working directory in tmp/work, so we need to set this to that subdirectory
# so the cmake class knows where to look.
S = "${WORKDIR}/git"

# The 'cmake-examples' project has several subdirectories for each step in our
# demo. We need to tell the cmake base class which directory contains the
# top-level CMakeLists.txt file. Most packages have the top-level
# CMakeLists.txt file in the root directory, and so this isn't usually
# necessary.
OECMAKE_SOURCEPATH = "${S}/4-producing-packages"
